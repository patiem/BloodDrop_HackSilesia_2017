package com.blooddrop.mail;

import com.blooddrop.bloodrequest.BloodRequest;
import com.blooddrop.donor.Donor;
import com.blooddrop.services.BloodRequestService;
import com.blooddrop.services.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;

import java.util.List;

@Component
public class SendNotification {

    @Autowired
    BloodRequestService bloodRequestService;

    @Autowired
    DonorService donorService;

    @Autowired
    EmailHtmlSender emailHtmlSender;

    public void sendNotificationToDonors(BloodRequest bloodRequest) {
        List<Donor> listOfDonors = donorService.getAllAvailableDonors(bloodRequest.getBloodGroup(), bloodRequest.getCity(), bloodRequest.getDate());
        for (Donor donor :
                listOfDonors) {
            Context context = new Context();
            context.setVariable("donorid", donor.getId());
            context.setVariable("requestid", bloodRequest.getId());
            EmailStatus emailStatus = emailHtmlSender.send(donor.getEmail(), "We need your blood to save live!", "mail/send-notification", context);
        }
    }
}
