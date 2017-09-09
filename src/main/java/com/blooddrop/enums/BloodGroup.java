package com.blooddrop.enums;

public enum BloodGroup {
    A_Rh_minus("A_MINUS"),
    A_Rh_plus("A_PLUS"),
    B_Rh_minus("B_MINUS"),
    B_Rh_plus("B_PLUS"),
    AB_Rh_minus("AB_MINUS"),
    AB_Rh_plus("AB_PLUS"),
    Zero_Rh_minus("ZERO_MINUS"),
    Zero_Rh_plus("ZERO_PLUS");

    private final String bloodgroup;

    BloodGroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getBloodgroup() {
        return this.bloodgroup;
    }

    @Override
    public String toString() {
        return this.bloodgroup;
    }

}
