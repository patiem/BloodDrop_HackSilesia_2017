package com.blooddrop.mail;

import com.blooddrop.bloodrequest.BloodRequest;
import com.blooddrop.donor.Donor;
import com.blooddrop.services.BloodRequestService;
import com.blooddrop.services.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;

@Component
public class SendInformation {

    @Autowired
    BloodRequestService bloodRequestService;

    @Autowired
    DonorService donorService;

    @Autowired
    EmailHtmlSender emailHtmlSender;

    public void sendInformation(Long donorId, Long requestid) {
        Donor donor = donorService.getDonorById(donorId);
        BloodRequest bloodRequest = bloodRequestService.getById(requestid);
        Context context = new Context();
        context.setVariable("id", bloodRequest.getId());
        context.setVariable("date", bloodRequest.getDate());
        context.setVariable("address", bloodRequest.getAdress());
        EmailStatus emailStatus = emailHtmlSender.send(donor.getEmail(), "We need your blood to save live!", "mail/send-notification", context);
    }
}