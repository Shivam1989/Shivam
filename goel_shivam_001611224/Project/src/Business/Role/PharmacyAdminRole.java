/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.AdministrativeRole.AdminWorkAreaJPanel;
import UserInterface.PharmacyAdmin.PharmacyWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author shivam
 */
public class PharmacyAdminRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new PharmacyWorkAreaJPanel(userProcessContainer,organization,enterprise,account,business);
    }
    public String toString() {
       return RoleType.PharmacyAdmin.getValue();
   }
}
