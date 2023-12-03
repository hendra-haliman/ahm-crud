package com.test.kendaraan.controller;

import com.test.kendaraan.model.Kendaraan;
import com.test.kendaraan.model.Search;
import com.test.kendaraan.service.KendaraanService;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class KendaraanController {
    @Autowired
    private KendaraanService kendaraanService;

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
        return "add";
    }

    @PostMapping("saveKendaraan")
    public String saveKendaraan(@Valid @ModelAttribute("kendaraan") Kendaraan kendaraan, BindingResult errors,
            RedirectAttributes redirectAttributes, @RequestParam(value = "action", required = true) String action) {

        if (action.equals("cancel")) {
            return "redirect:monitoring";
        }

        if (errors.hasErrors()) {
            // redirectAttributes.addFlashAttribute("message", "Failed");
            return "add";
        } else {
            redirectAttributes.addFlashAttribute("message", "Success");
            redirectAttributes.addFlashAttribute("pemilik", kendaraan.getNamaPemilik());
            kendaraanService.addKendaraan(kendaraan);
        }

        return "redirect:add";
    }

    @GetMapping("/edit")
    public String editKendaraan(Model model, @RequestParam(name = "noRegistrasi") String noRegistrasi) {
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
    public String searchKendaraan(Model model, @Valid @ModelAttribute("search") Search search) {
        List<Kendaraan> kendaraanList;

        if ((search == null) || (Strings.isEmpty(search.getSearchTerm()))) {
            kendaraanList = kendaraanService.listKendaraan();
        } else {
            kendaraanList = kendaraanService.searchByIdOrByNamaPemilik(search.getSearchTerm(), search.getSearchTerm());
        }

        model.addAttribute("kendaraanList", kendaraanList);
        return "monitoring";
    }

}
