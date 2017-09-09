package com.blooddrop.controller;

import com.blooddrop.bloodrequest.BloodRequest;
import com.blooddrop.mail.SendNotification;
import com.blooddrop.services.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        SendNotification sendNotification = new SendNotification();
        sendNotification.sendNotificationToDonors(bloodRequest);

    }

    @RequestMapping(value = "")
    public String createBloodRequest(Model model){
        return "createBloodRequest";
    }
}
