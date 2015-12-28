/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DonorSensor;

import java.util.Date;

/**
 *
 * @author shivam
 */
public class VitalSign {
     String BloodType;
    int AntigenA;
    int AntigenB;
    String OrganType;
    int AntigenC;
    int AntigenDB1;
    int AntigenDQ;
    String BloodPlatlets;
    String BloodPressure;
    String HemoglobinLevel;
    int BodySize;
    private String timestamp;
    Date date = new Date();

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getBodySize() {
        return BodySize;
    }

    public void setBodySize(int BodySize) {
        this.BodySize = BodySize;
    }

    public int getAntigenC() {
        return AntigenC;
    }

    public void setAntigenC(int AntigenC) {
        this.AntigenC = AntigenC;
    }

    public int getAntigenDB1() {
        return AntigenDB1;
    }

    public void setAntigenDB1(int AntigenDB1) {
        this.AntigenDB1 = AntigenDB1;
    }

    public int getAntigenDQ() {
        return AntigenDQ;
    }

    public void setAntigenDQ(int AntigenDQ) {
        this.AntigenDQ = AntigenDQ;
    }

    public String getBloodPlatlets() {
        return BloodPlatlets;
    }

    public void setBloodPlatlets(String BloodPlatlets) {
        this.BloodPlatlets = BloodPlatlets;
    }

    public String getBloodPressure() {
        return BloodPressure;
    }

    public void setBloodPressure(String BloodPressure) {
        this.BloodPressure = BloodPressure;
    }

    public String getHemoglobinLevel() {
        return HemoglobinLevel;
    }

    public void setHemoglobinLevel(String HemoglobinLevel) {
        this.HemoglobinLevel = HemoglobinLevel;
    }

    public String getOrganType() {
        return OrganType;
    }

    public void setOrganType(String OrganType) {
        this.OrganType = OrganType;
    }

    public String getBloodType() {
        return BloodType;
    }

    public void setBloodType(String BloodType) {
        this.BloodType = BloodType;
    }

    public int getAntigenA() {
        return AntigenA;
    }

    public void setAntigenA(int AntigenA) {
        this.AntigenA = AntigenA;
    }

    public int getAntigenB() {
        return AntigenB;
    }

    public void setAntigenB(int AntigenB) {
        this.AntigenB = AntigenB;
    }
   public String toString()   {
        return String.valueOf(this.timestamp);} 
}
