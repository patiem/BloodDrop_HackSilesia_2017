package com.blooddrop.bloodrequest;

import com.blooddrop.enums.BloodGroup;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class BloodRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BloodGroup bloodGroup;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;
    private String address;
    private String patient;

    public BloodRequest(BloodGroup bloodGroup, Date date, String address, String patient) {
        this.bloodGroup = bloodGroup;
        this.date = date;
        this.address = address;
        this.patient = patient;
    }

    public BloodRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }
}
