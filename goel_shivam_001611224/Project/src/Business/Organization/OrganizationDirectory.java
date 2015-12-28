/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author shivam
 */
public class OrganizationDirectory {
     private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Doctor.getValue())){
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Nurse.getValue())){
            organization = new NurseOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Receptionist.getValue())) {
            organization = new ReceptionistOrganization();
            this.organizationList.add(organization);}
         else if (type.getValue().equals(Type.LabAssistant.getValue())){
            organization = new LabOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Donor.getValue())) {
            organization = new DonorOrganization();
            this.organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.OrganBankReceptionist.getValue())) {
            organization = new OrganBankReceptionistOrganization();
            this.organizationList.add(organization);
        }
         else if (type.getValue().equals(Organization.Type.Patient.getValue())) {
            organization = new PatientOrganization();
            this.organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.PharmacyAdmin.getValue())) {
            organization = new PharmacyAdminOrganization();
            this.organizationList.add(organization);
        }
        return organization;
    }
}
