package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser{
    
	
    // MEMBER VARIABLES   
    private ArrayList<String> patientNotes;
	
    //Constructor that takes an ID
    public Physician (Integer id) {
    	super(id);
    }
    
    // INTERFACES Implement HIPAACompliantUser!
	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		if(( pin > 999) & ( pin < 10000)) {
			return true;
		}
		else {
			return false;
		}
			
	}
		
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		if (getId() == confirmedAuthID) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//METHODS
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

    // Setters & Getters
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}

	

}
