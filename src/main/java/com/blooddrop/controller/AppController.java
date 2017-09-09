package com.blooddrop.controller;

import com.blooddrop.donor.Donor;
import com.blooddrop.services.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {
    @Autowired
    DonorService donorService;

    @RequestMapping("")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("fill")
    public String fill(Model model) {
        model.addAttribute("donor", new Donor());
        return "fill";
    }

    @PostMapping("fill")
    public String onRegister(@ModelAttribute Donor donor) {
        return "results";
    }
}
