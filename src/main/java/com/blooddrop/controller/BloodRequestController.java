package com.blooddrop.controller;

import com.blooddrop.bloodrequest.BloodRequest;
import com.blooddrop.mail.SendInformation;
import com.blooddrop.mail.SendNotification;
import com.blooddrop.enums.BloodGroup;
import com.blooddrop.services.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
        bloodRequestService.addBloodRequest(bloodRequest);
        SendNotification sendNotification = new SendNotification();
        sendNotification.sendNotificationToDonors(bloodRequest);
    }

    @RequestMapping(value = "/{donorid}&{requestid}", method = {RequestMethod.POST})
    public void sendBloodRequestInformation(@PathVariable("donorId") long donorid, @PathVariable("requestid") long requestid) {
        SendInformation sendInformation = new SendInformation();
        sendInformation.sendInformation(donorid, requestid);
    }

    @RequestMapping(value = "")
    public String createBloodRequest(Model model){

        model.addAttribute("bloodGroups", BloodGroup.values());
        return "createBloodRequest";
    }
}
