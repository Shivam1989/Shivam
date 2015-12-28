/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Person.PersonDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author shivam
 */
public abstract class Organization {
    private String name;
    private WorkQueue workQueue;
    private PersonDirectory personDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationId;
    private static int counter;
    protected ArrayList<Role> roles = null;
    public enum Type{
        Admin("Admin Organization") 
        ,
        Doctor("Doctor Organization")
        , 
        Receptionist("Receptionist Organization")
        ,
        Nurse("Nurse Organization")
        ,
        LabAssistant("Lab Organization")
        ,
        OrganBankReceptionist("Organ Bank Receptionist Organization ")
        ,
        Donor("Donor Organization")
        ,
        OrganBankAdmin("Organ Bank Admin")
        ,
        Patient("Patient Organization")
        ,
        PharmacyAdmin("PharmacyAdmin");
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        personDirectory = new PersonDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationId = counter;
        ++counter;
        this.roles = new ArrayList();
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
    
      
}
