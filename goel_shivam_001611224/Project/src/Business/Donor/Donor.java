/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Donor;

import Business.DonorSensor.VitalSign;
import Business.DonorSensor.VitalSignDirectory;
import Business.Person.Person;

/**
 *
 * @author shivam
 */
public class Donor extends Person {
    private String Gender;
    private String Dob;
    
    private String Address;
    private String Zip;
    private String Email;
    private String Area;
    private String Phone;
    private String town;

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
    private LabTest labtest;
    private VitalSignDirectory vitalSignDir;
 
   public Donor()  {
        super();
        labtest = new LabTest();
        vitalSignDir = new VitalSignDirectory();
 }

    public VitalSignDirectory getVitalSignDir() {
        return vitalSignDir;
    }

    public void setVitalSignDir(VitalSignDirectory vitalSignDir) {
        this.vitalSignDir = vitalSignDir;
    }

//    public String getDOB() {
//        return DOB;
//    }
//
//    public void setDOB(String DOB) {
//        this.DOB = DOB;
//    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getZip() {
        return Zip;
    }

    public void setZip(String Zip) {
        this.Zip = Zip;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

   

    public LabTest getLabtest() {
        return labtest;
    }

    public void setLabtest(LabTest labtest) {
        this.labtest = labtest;
    }
    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String Dob) {
        this.Dob = Dob;
    }
}
