package com.blooddrop.services;

import com.blooddrop.donor.Donor;
import com.blooddrop.enums.BloodGroup;
import com.blooddrop.repository.DonorRepository;
import com.blooddrop.utils.ShiftDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DonorService {

    @Autowired
    private DonorRepository donorRepository;

    public List<Donor> getAllAvailableDonors(BloodGroup bloodGroup, String city, Date date) {
        date = ShiftDate.addDays(date, 60);
        return donorRepository.getAllDonorsByBloodGroupAndLastDonateDateBeforeAndCityEquals(bloodGroup, date, city);
    }

    public Donor getDonorById(Long id) {
        return donorRepository.getDonorById(id);
    }

    public void addDonor(Donor donor) {
        donorRepository.save(donor);
    }

    public long getDonorsNumber() {
        return donorRepository.count();
    }
}
