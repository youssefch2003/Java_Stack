package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;


public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {

    private ArrayList<String> securityIncidents;
    private String role;

    public AdminUser(Integer id, String role) {
        super(id);
        this.securityIncidents = new ArrayList<String>();
        this.role = role;
    }

    @Override
    public boolean assignPin(int pin) {
        String strPin = String.valueOf(pin);
        if (strPin.length() < 6) {
            return false;
        }
        setPin(pin);
        return true;
    }

    @Override
    public boolean accessAuthorized(Integer idp) {
        if (getId().equals(idp)) {
            return true;
        } else {
            authIncident();
            return false;
        }
    }

    @Override
    public ArrayList<String> reportSecurityIncidents() {
        return securityIncidents;
    }

    public void newIncident(String notes) {
        String report = String.format(
                "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n",
                new Date(), getId(), notes
        );
        securityIncidents.add(report);
    }

    public void authIncident() {
        String report = String.format(
                "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n",
                new Date(), getId(), "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
