/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Role.OrganBankAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author shivam
 */
public class OrganBankAdminOrganization extends Organization {
    public OrganBankAdminOrganization() {
        super(Organization.Type.OrganBankAdmin.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new OrganBankAdminRole());
        return roles;
    }
}
