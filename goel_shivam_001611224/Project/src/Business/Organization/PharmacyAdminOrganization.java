/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Drug.Drug;
import Business.Role.PharmacyAdminRole;
import Business.Role.ReceptionistRole;
import Business.Role.Role;
import Business.Supplier.Supplier;
import Business.Supplier.SupplierDirectory;
import java.util.ArrayList;

/**
 *
 * @author shivam
 */
public class PharmacyAdminOrganization extends Organization {
private SupplierDirectory suppDirectory;
    public PharmacyAdminOrganization() {
        super(Organization.Type.PharmacyAdmin.getValue());
        suppDirectory =new  SupplierDirectory();
        Supplier s1 = suppDirectory.addSupplier();
        s1.setSupplyName("Ranbaxy");
        Drug d1 = s1.getDrugDir().addDrug();
        d1.setDrugName("Crocin");
        d1.setId(1);
        d1.setMarketPrice(45);
        d1.setQuantity(20);
        Drug d3 = s1.getDrugDir().addDrug();
        d3.setDrugName("Dispirin");
        d3.setId(2);
        d3.setMarketPrice(12);
        d3.setQuantity(50);
         Supplier s2 = suppDirectory.addSupplier();
         s2.setSupplyName("Novitis");
         Drug d2 = s2.getDrugDir().addDrug();
        d2.setDrugName("Combiflame");
        d2.setId(3);
        d2.setMarketPrice(20);
        d2.setQuantity(10);
        Drug d4 = s2.getDrugDir().addDrug();
        d4.setDrugName("D-Cold");
        d4.setId(4);
        d4.setMarketPrice(50);
        d4.setQuantity(34);
         
    }

    public SupplierDirectory getSuppDirectory() {
        return suppDirectory;
    }

    public void setSuppDirectory(SupplierDirectory suppDirectory) {
        this.suppDirectory = suppDirectory;
    }
 
   @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PharmacyAdminRole());
        return roles;
    }
    
}
