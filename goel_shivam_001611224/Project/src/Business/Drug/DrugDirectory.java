/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Drug;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shivam
 */
public class DrugDirectory {
     private List<Drug> DrugDir;

    public DrugDirectory() {
    DrugDir = new ArrayList<Drug>();
    }
    
    
    public Drug addDrug(){
        Drug d = new Drug();
        DrugDir.add(d);
        return d;
    }
    
    public void removeDrug(Drug d){
         DrugDir.remove(d);
    }

    public List<Drug> getDrugDir() {
        return DrugDir;
    }

    public void setDrugDir(List<Drug> DrugDir) {
        this.DrugDir = DrugDir;
    }
    
    
}
