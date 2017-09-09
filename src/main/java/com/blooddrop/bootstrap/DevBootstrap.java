package com.blooddrop.bootstrap;

import com.blooddrop.donor.Donor;
import com.blooddrop.enums.BloodGroup;
import com.blooddrop.services.BloodRequestService;
import com.blooddrop.services.DonorService;
import com.blooddrop.utils.ShiftDate;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    BloodRequestService bloodRequestService;
    DonorService donorService;

    public DevBootstrap(BloodRequestService bloodRequestService, DonorService donorService) {
        this.bloodRequestService = bloodRequestService;
        this.donorService = donorService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.onInit();
    }

    private void onInit() {
        String sourceDate = "2017-08-29";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate = null;
        try {
            myDate = format.parse(sourceDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        myDate = ShiftDate.addDays(myDate, 1);
        donorService.addDonor(new Donor("bujakowski@gmail.com","tomek", "Krakow", BloodGroup.B_Rh_minus, myDate));
        donorService.addDonor(new Donor("pgurdek@gmail.com","Piotrek", "Krakow", BloodGroup.Zero_Rh_minus, myDate));
        donorService.addDonor(new Donor("sebastian.kt7@gmail.com","Seba", "Krakow", BloodGroup.B_Rh_minus, myDate));
    }

}
