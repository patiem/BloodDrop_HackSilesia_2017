package com.blooddrop.services;

import com.blooddrop.bloodrequest.BloodRequest;
import com.blooddrop.repository.BloodRequestRepository;
import com.blooddrop.repository.DonorsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BloodRequestService {

    @Autowired
    private BloodRequestRepository bloodRequestRepository;

    @Autowired
    private DonorsHandler donorsHandler;

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
