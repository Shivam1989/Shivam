/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Supplier;

import Business.Drug.DrugDirectory;

/**
 *
 * @author shivam
 */
public class Supplier {
     private String supplyName;
    private DrugDirectory DrugDir;

    public Supplier() {
    DrugDir = new DrugDirectory();
    }

    public String getSupplyName() {
        return supplyName;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName;
    }

    public DrugDirectory getDrugDir() {
        return DrugDir;
    }

    public void setDrugDir(DrugDirectory DrugDir) {
        this.DrugDir = DrugDir;
    }

    @Override
    public String toString() {
        return  supplyName ;
    }
    
}
