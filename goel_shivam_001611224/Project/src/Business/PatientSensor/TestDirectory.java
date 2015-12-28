/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PatientSensor;

import Business.Donor.LabTest;
import java.util.ArrayList;

/**
 *
 * @author shivam
 */
public class TestDirectory {
     private ArrayList<Test> testdir ;
     public TestDirectory()
     {
     testdir= new ArrayList<>();
    }

    public ArrayList<Test> getTestdir() {
        return testdir;
    }

    public void setTestdir(ArrayList<Test> testdir) {
        this.testdir = testdir;
    }
     public void settestdir(ArrayList<Test> testdir) {
        this.testdir = testdir;
    }
     public Test addTest()
        {Test t = new Test();
        testdir.add(t);
        return t;
        }
}

