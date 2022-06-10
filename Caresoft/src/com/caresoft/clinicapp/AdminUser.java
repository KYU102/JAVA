package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser{
	
	//MEMEBER VARIABLES
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(Integer id, String role) {
    	super(id);
    	this.employeeID = id;
    	this.role = role;
    }
    //METHODS
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    //INTERFACES
	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		System.out.println("***" + pin);
		if(pin > 99999 && pin < 1000000) {
			System.out.println("true");
			return true;
		}
		else {
			return false;
		}
	}
	
	
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		System.out.println("****" + getEmployeeID());
		// TODO Auto-generated method stub
		if(getEmployeeID() == confirmedAuthID) {
			return true;
		}
		else {
//			authIncident();
			return false;
		}
	
	}
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		return getSecurityIncidents();
		
		
	}

    //Setters & Getters
    
	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
	
	

    



}
