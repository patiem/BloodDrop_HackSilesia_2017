package com.blooddrop.mail;

import com.blooddrop.bloodrequest.BloodRequest;
import com.blooddrop.donor.Donor;
import com.blooddrop.services.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;

import java.util.List;

@Component
public class SendNotification {

    @Autowired
    BloodRequestService bloodRequestService;

    @Autowired
    EmailHtmlSender emailHtmlSender;

    public Integer sendNotificationToDonors(BloodRequest bloodRequest) {
        List<Donor> listOfDonors = bloodRequestService.getAllDonorsByBloodGroup(bloodRequest.getBloodGroup());
        for (Donor donor :
                listOfDonors) {
            Context context = new Context();
            context.setVariable("donorid", donor.getId());
            context.setVariable("requestid", bloodRequest.getId());
            EmailStatus emailStatus = emailHtmlSender.send(donor.getEmail(), "We need your blood to save live!", "mail/send-notification", context);

    }
        return listOfDonors.size();
    }
}
