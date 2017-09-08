package com.blooddrop.services;

import com.blooddrop.repository.BloodRequestRepository;
import com.blooddrop.repository.DonorsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodRequestService {

    @Autowired
    private BloodRequestRepository bloodRequestRepository;

    @Autowired
    private DonorsHandler donorsHandler;
}
