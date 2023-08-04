package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {

	   private ArrayList<String> patientNotes;
	
	
	
	
    public  Physician(Integer id) {
		super(id);
		// TODO Auto-generated constructor stub
		patientNotes = new ArrayList<>();
				}
    
    
    
@Override
    public boolean assignPin(int pin) {
	String strPin=String.valueOf(pin);
    if (strPin.length() < 4){
		return false;
	}
	setPin(pin);
	return true ; 
    }
@Override
public boolean accessAuthorized(Integer id) {
    // TODO Auto-generated method stub
    if(getId() == id ) {
        return true;
    }
    return false;
}


    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", getId());
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
    
    
    
    
    
    
    
    
    
    
    
	

}
