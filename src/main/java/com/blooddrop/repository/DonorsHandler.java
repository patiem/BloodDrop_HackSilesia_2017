package com.blooddrop.repository;

import com.blooddrop.enums.BloodGroup;

public interface DonorsHandler {
    void getAllDonorsByBloodGroup(BloodGroup bloodGroup);
}
