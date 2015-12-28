/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DonorSensor;

import Business.PatientSensor.Test;
import java.util.ArrayList;

/**
 *
 * @author shivam
 */
public class VitalSignDirectory {
     private ArrayList<VitalSign> vitalSignDir ;
     public VitalSignDirectory()
     {
     vitalSignDir= new ArrayList<>();
    }

    public ArrayList<VitalSign> getVitalSignDir() {
        return vitalSignDir;
    }

    public void setVitalSignDir(ArrayList<VitalSign> vitalSignDir) {
        this.vitalSignDir = vitalSignDir;
    }

   

     public VitalSign addvitalsign()
        {VitalSign vs = new VitalSign();
        vitalSignDir.add(vs);
        return vs;
        }
    
}
