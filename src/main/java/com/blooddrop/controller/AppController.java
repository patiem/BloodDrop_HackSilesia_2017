package com.blooddrop.controller;

import com.blooddrop.donor.Donor;
import com.blooddrop.enums.BloodGroup;
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

    @RequestMapping("filldb")
    public String send(){
        Donor donor = new Donor();
        donor.setCity("Katowice");
        donor.setBloodGroup(BloodGroup.A_Rh_plus);
        donor.setEmail("sebastian.kt7@gmail.com");
        donor.setName("seba");
        donorService.addDonor(donor);
        return "redirect:/";
    }

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("donorNumber", donorService.getDonorsNumber());

        return "index";
    }

    @RequestMapping("fill")
    public String fill(Model model) {
        model.addAttribute("donor", new Donor());
        return "fill";
    }

    @PostMapping("fill")
    public String onRegister(@ModelAttribute Donor donor) {
        donorService.addDonor(donor);
        return "results";
    }
}
