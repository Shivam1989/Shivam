/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Donor;

import java.util.ArrayList;

/**
 *
 * @author shivam
 */
public class LabTestDirectory {
     private ArrayList<LabTest> labtestdir ;
     public LabTestDirectory()
     {
     labtestdir= new ArrayList<>();
    }

    public ArrayList<LabTest> getLabtestdir() {
        return labtestdir;
    }

    public void setLabtestdir(ArrayList<LabTest> labtestdir) {
        this.labtestdir = labtestdir;
    }
     public LabTest addLabTest()
        {LabTest lt = new LabTest();
        labtestdir.add(lt);
        return lt;
        }
}
