package com.blooddrop.bootstrap;

import com.blooddrop.donor.Donor;
import com.blooddrop.enums.BloodGroup;
import com.blooddrop.services.BloodRequestService;
import com.blooddrop.services.DonorService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

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
        donorService.addDonor(new Donor("bujakowski@gmail.com","tomek", "Krakow", BloodGroup.B_Rh_minus));
        donorService.addDonor(new Donor("pgurdek@gmail.com","Piotrek", "Krakow", BloodGroup.Zero_Rh_minus));
        donorService.addDonor(new Donor("sebastian.kurant@gmail.com","Seba", "Krakow", BloodGroup.B_Rh_minus));
    }

}
