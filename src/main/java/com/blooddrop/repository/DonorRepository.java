package com.blooddrop.repository;

import com.blooddrop.donor.Donor;
import com.blooddrop.enums.BloodGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorRepository extends CrudRepository<Donor, Long> {
    Donor getDonorById(Long id);
    List<Donor> getAllDonorsByBloodGroup(BloodGroup bloodGroup);
}
