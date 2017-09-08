package com.blooddrop.repository;

import com.blooddrop.bloodrequest.BloodRequest;
import com.blooddrop.enums.BloodGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodRequestRepository extends CrudRepository<BloodRequest,Long>
{}
