package com.test.kendaraan.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.kendaraan.model.Kendaraan;
import com.test.kendaraan.model.Owner;
import com.test.kendaraan.model.Search;
import com.test.kendaraan.repository.OwnerRepository;
import com.test.kendaraan.service.KendaraanService;

@Controller
public class KendaraanController {
    @Autowired
    private KendaraanService kendaraanService;

    @Autowired
    private OwnerRepository ownerRepository;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/monitoring")
    public String monitoring(Model model) {
        List<Kendaraan> kendaraans = kendaraanService.listKendaraan();
        Search search = new Search();

        model.addAttribute("kendaraanList", kendaraans);
        model.addAttribute("search", search);
        return "monitoring";
    }

    @GetMapping("/detail")
    public String detailKendaraan(Model model, @RequestParam(name = "noRegistrasi") String noRegistrasi) {
        Kendaraan kendaraan = kendaraanService.findById(noRegistrasi);
        model.addAttribute("kendaraan", kendaraan);
        return "detail";
    }

    @GetMapping("/add")
    public String addKendaraan(Model model) {
        model.addAttribute("kendaraan", new Kendaraan());
        List<Owner> ownerList = ownerRepository.findAll();
        model.addAttribute("ownerList", ownerList);

        return "add";
    }

    @PostMapping("saveKendaraan")
    public String saveKendaraan(@Valid @ModelAttribute("kendaraan") Kendaraan kendaraan, BindingResult errors,
            RedirectAttributes redirectAttributes, @RequestParam(value = "action", required = true) String action,
            Model model) {

        if (action.equals("cancel")) {
            return "redirect:monitoring";
        }

        if (errors.hasErrors()) {
            // redirectAttributes.addFlashAttribute("message", "Failed");
            List<Owner> ownerList = ownerRepository.findAll();
            model.addAttribute("ownerList", ownerList);

            return "add";
        } else {
            redirectAttributes.addFlashAttribute("message", "Success");
            // redirectAttributes.addFlashAttribute("pemilik", kendaraan.getNamaPemilik());
            kendaraanService.addKendaraan(kendaraan);
        }

        return "redirect:add";
    }

    @GetMapping("/edit")
    public String editKendaraan(Model model,
            @RequestParam(name = "noRegistrasi") String noRegistrasi) {
        Kendaraan kendaraan = kendaraanService.findById(noRegistrasi);
        model.addAttribute("kendaraan", kendaraan);
        return "edit";
    }

    @PostMapping("/editKendaraan")
    public String updateKendaraan(@ModelAttribute Kendaraan kendaraan,
            @RequestParam(value = "action", required = true) String action,
            @RequestParam(value = "old_noRegistrasi", required = true) String old_noRegistrasi) {
        if (action.equals("cancel")) {
            return "redirect:monitoring";
        }

        kendaraanService.deleteKendaraanById(old_noRegistrasi);

        kendaraanService.updateKendaraan(kendaraan);
        return "redirect:/monitoring";
    }

    @ResponseBody
    @GetMapping("/delete")
    public String deleteUser(@RequestParam(name = "noRegistrasi") String noRegistrasi) {
        kendaraanService.deleteKendaraanById(noRegistrasi);

        return "user deleted.";
    }

    @ResponseBody
    @GetMapping("/search")
    public List<Kendaraan> search(@RequestParam(name = "noRegistrasi") String noRegistrasi) {
        return kendaraanService.search(noRegistrasi);
    }

    @PostMapping("searchKendaraan")
    public String searchKendaraan(Model model,
            @Valid @ModelAttribute("search") Search search,
            @RequestParam(value = "action", required = true) String action) {
        List<Kendaraan> kendaraanList;
        if (action.equals("add")) {
            return "redirect:/add";
        }

        if ((search == null) || (Strings.isEmpty(search.getSearchTerm()))) {
            kendaraanList = kendaraanService.listKendaraan();
        } else {
            System.out.println(search.getSearchTerm());
            kendaraanList = kendaraanService.searchByIdOrByNamaPemilik(search.getSearchTerm());
        }

        model.addAttribute("kendaraanList", kendaraanList);
        return "monitoring";
    }

}
