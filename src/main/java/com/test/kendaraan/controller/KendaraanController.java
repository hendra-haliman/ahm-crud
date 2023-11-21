package com.test.kendaraan.controller;

import com.test.kendaraan.model.Kendaraan;
import com.test.kendaraan.service.KendaraanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class KendaraanController {
    @Autowired
    private KendaraanService kendaraanService;
    
    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    @GetMapping("/monitoring")
    public String monitoring(Model model) {
        List<Kendaraan> kendaraans = kendaraanService.listKendaraan();
        model.addAttribute("kendaraanList", kendaraans);
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
    public String saveUser(@ModelAttribute("kendaraan") Kendaraan kendaraan, BindingResult errors) {
        kendaraanService.addKendaraan(kendaraan);
        return "redirect:/monitoring";
    }
    
    @GetMapping("/edit")
    public String editKendaraan(Model model, @RequestParam(name = "noRegistrasi") String noRegistrasi) {
        Kendaraan kendaraan = kendaraanService.findById(noRegistrasi);
        model.addAttribute("kendaraan", kendaraan);
        return "edit";
    }
    
    @PostMapping("/edit")
    public String updateKendaraan(@ModelAttribute Kendaraan kendaraan) {
        kendaraanService.updateKendaraan(kendaraan);
        return "redirect:/monitoring";
    }
    
    @ResponseBody
    @GetMapping("/delete")
    public String deleteUser(@RequestParam(name = "noRegistrasi") String noRegistrasi) {
        kendaraanService.deleteKendaraanById(noRegistrasi);

        return "user deleted.";
    }
    
    

}
