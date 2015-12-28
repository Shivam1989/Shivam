/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author shivam
 */
public class OrganBankEnterprise extends Enterprise {
    public OrganBankEnterprise(String name,double latitude,double longitude) {
        super(name, Enterprise.EnterpriseType.OrganBank);
    }

    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
