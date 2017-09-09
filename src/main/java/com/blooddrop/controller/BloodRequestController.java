package com.blooddrop.controller;

import com.blooddrop.bloodrequest.BloodRequest;
import com.blooddrop.enums.BloodGroup;
import com.blooddrop.services.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/bloodrequest")
@Controller
public class BloodRequestController {

    @Autowired
    private BloodRequestService bloodRequestService;

    @RequestMapping(value = "", method = {RequestMethod.POST})
    public void addBloodRequest(@RequestBody BloodRequest bloodRequest) {
        System.out.println(bloodRequest);
    }

    @RequestMapping(value = "")
    public String createBloodRequest(Model model){

        model.addAttribute("bloodGroups", BloodGroup.values());
        return "createBloodRequest";
    }
}
