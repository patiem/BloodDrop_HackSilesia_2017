package com.blooddrop.controller;

import com.blooddrop.bloodrequest.BloodRequest;
import com.blooddrop.mail.SendInformation;
import com.blooddrop.mail.SendNotification;
import com.blooddrop.enums.BloodGroup;
import com.blooddrop.services.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/bloodrequest")
@Controller
public class BloodRequestController {

    @Autowired
    private BloodRequestService bloodRequestService;

    @Autowired
    private SendInformation sendInformation;

    @Autowired
    private SendNotification sendNotification;


    @RequestMapping(value = "", method = {RequestMethod.POST})
    public ModelAndView addBloodRequest(@ModelAttribute BloodRequest bloodRequest, Model model) {
        System.out.println(bloodRequest.getDate());
        bloodRequestService.addBloodRequest(bloodRequest);
//        BloodRequest test = bloodRequestService.getById(bloodRequest.getId());
//        model.addAttribute("bloodRequest", test);
        Integer count = sendNotification.sendNotificationToDonors(bloodRequest);
        System.out.println(count);
        model.addAttribute(count);
//        return "redirect:requestResults";
        return new ModelAndView("redirect:/requestResults?count="+count);
    }

    @RequestMapping(value = "/{donorid}/{requestid}")
    public String sendBloodRequestInformation(@PathVariable("donorid") long donorid, @PathVariable("requestid") long requestid) {
        sendInformation.sendInformation(donorid, requestid);
        return "mail/thanks";
    }

    @RequestMapping(value = "")
    public String createBloodRequest(Model model){
        model.addAttribute("bloodRequest", new BloodRequest());
//        model.addAttribute("bloodGroups", BloodGroup.values());
        return "createBloodRequest";
    }
}
