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
    private String rck;
    private String city;
    private String patient;

    public BloodRequest(BloodGroup bloodGroup, Date date, String rck, String patient, String city) {
        this.city = city;

        this.bloodGroup = bloodGroup;
        this.date = date;
        this.rck = rck;
        this.patient = patient;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getRck() {
        return rck;
    }

    public void setRck(String adress) {
        this.rck = adress;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "BloodRequest{" +
                "id=" + id +
                ", bloodGroup=" + bloodGroup +
                ", date=" + date +
                ", rck='" + rck + '\'' +
                ", city='" + city + '\'' +
                ", patient='" + patient + '\'' +
                '}';
    }
}
