package com.blooddrop.controller;

import com.blooddrop.services.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        System.out.println("ooo");
        return "fill";
    }

    @PostMapping("fill")
    public String onRegister(Model model) {
        System.out.println("dupa");
        return "results";
    }
}
