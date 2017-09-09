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
        context.setVariable("rck", bloodRequest.getRck());
        context.setVariable("address", bloodRequest.getCity());
        context.setVariable("patient", bloodRequest.getPatient());
        context.setVariable("donorid", donor.getId());
        context.setVariable("requestid", bloodRequest.getId());
        EmailStatus emailStatus = emailHtmlSender.send(donor.getEmail(), "We need your blood to save live!", "mail/send-information", context);
    }
}
