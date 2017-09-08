package com.blooddrop.bloodrequest;

import com.blooddrop.enums.BloodGroup;
import com.blooddrop.repository.BloodRequestRepository;
import com.blooddrop.repository.DonorsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonorHandlerImpl implements DonorsHandler {

    @Override
    public void getAllDonorsByBloodGroup(BloodGroup bloodGroup) {
        System.out.println("works");
    }
}
