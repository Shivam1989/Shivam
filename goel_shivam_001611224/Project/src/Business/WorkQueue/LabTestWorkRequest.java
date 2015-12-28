/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Employee.Employee;
import Business.Person.Person;

/**
 *
 * @author shivam
 */
public class LabTestWorkRequest extends WorkRequest{
   private String testResult;
   private Person donor;
private Person patient;

    public Person getPatient() {
        return patient;
    }

    public void setPatient(Person patient) {
        this.patient = patient;
    }
    public Person getDonor() {
        return donor;
    }

    public void setDonor(Person donor) {
        this.donor = donor;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    } 
   
}
