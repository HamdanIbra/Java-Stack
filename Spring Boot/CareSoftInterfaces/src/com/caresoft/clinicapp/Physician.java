package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser{
public Physician(Integer id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

//... imports class definition...
    private int pin;
    // Inside class:    
    private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
    // TO DO: Implement HIPAACompliantUser!
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		int numberOfDigits = String.valueOf(pin).length();
		if (numberOfDigits==4) {
			this.pin=pin;
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		if (confirmedAuthID==this.id) {
			return true;
		}
		else {
		return false;
		}
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	
    // TO DO: Setters & Getters
	

}
