/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.NurseRole;
import Business.Role.OrganBankReceptionistRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author shivam
 */
public class OrganBankReceptionistOrganization extends Organization{

   public OrganBankReceptionistOrganization() {
        super(Organization.Type.OrganBankReceptionist.getValue());
    }
 
   @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new OrganBankReceptionistRole());
        return roles;
    }
    }
