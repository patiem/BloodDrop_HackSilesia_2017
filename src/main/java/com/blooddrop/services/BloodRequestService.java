package com.blooddrop.services;

import com.blooddrop.bloodrequest.BloodRequest;
import com.blooddrop.donor.Donor;
import com.blooddrop.enums.BloodGroup;
import com.blooddrop.repository.BloodRequestRepository;
import com.blooddrop.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BloodRequestService {

    @Autowired
    private BloodRequestRepository bloodRequestRepository;

    @Autowired
    private DonorRepository donorsHandler;

    public List<Donor> getAllDonorsByBloodGroup(BloodGroup bloodGroup) {
        return donorsHandler.getAllDonorsByBloodGroup(bloodGroup);
    }

    public List<BloodRequest> getAllBloodRequests() {
        List<BloodRequest> bloodRequests = new ArrayList<>();
        bloodRequestRepository.findAll().forEach(bloodRequests::add);
        return bloodRequests;
    }

    public void addBloodRequest(BloodRequest item) {
        bloodRequestRepository.save(item);
    }

    public BloodRequest getById(Long id) {
        BloodRequest bloodRequest = bloodRequestRepository.findOne(id);
         return bloodRequest;
    }

    public void remove(Long id) {
        BloodRequest item = bloodRequestRepository.findOne(id);

        if (item != null) {
            bloodRequestRepository.delete(id);
        }

    }
}
