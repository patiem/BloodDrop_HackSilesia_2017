package com.blooddrop.donor;

import com.blooddrop.enums.BloodGroup;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String name;
    private String city;
    private BloodGroup bloodGroup;
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date lastDonateDate = setDeafultDate();

    private Date setDeafultDate() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse( "2017-03-29");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Donor() {
        System.out.println(this.lastDonateDate);
    }

    public Donor(String email, String name, String city, BloodGroup bloodGroup, Date lastDonateDate) {
        this.email = email;
        this.name = name;
        this.city = city;
        this.bloodGroup = bloodGroup;
        this.lastDonateDate = lastDonateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Date getLastDonateDate() {
        return lastDonateDate;
    }

    public void setLastDonateDate(Date lastDonateDate) {
        this.lastDonateDate = lastDonateDate;
    }

    @Override
    public String toString() {
        return new StringBuilder(this.getEmail() + this.getBloodGroup()).toString();
    }
}
