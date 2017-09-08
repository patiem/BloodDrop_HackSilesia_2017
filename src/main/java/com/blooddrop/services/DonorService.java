package com.blooddrop.services;

import com.blooddrop.donor.Donor;
import com.blooddrop.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonorService {

    @Autowired
    private DonorRepository donorRepository;

    public void addDonor(Donor donor) {
        donorRepository.save(donor);
    }
}
