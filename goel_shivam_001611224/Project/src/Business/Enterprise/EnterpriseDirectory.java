/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author shivam
 */
public class EnterpriseDirectory {
  private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }
    
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type,double latitude,double longitude){
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.Hospital){
            enterprise = new HospitalEnterprise(name,latitude,longitude);
            enterprise.setLatitude(latitude);
            enterprise.setLongitude(longitude);
            enterpriseList.add(enterprise);
        }
        else if(type == Enterprise.EnterpriseType.OrganBank){
            enterprise = new OrganBankEnterprise(name,latitude,longitude);
            enterprise.setLatitude(latitude);
            enterprise.setLongitude(longitude);
            enterpriseList.add(enterprise);
        
        }
        else if(type == Enterprise.EnterpriseType.Pharmacy){
            enterprise = new PharmacyEnterprise(name,latitude,longitude);
            enterprise.setLatitude(latitude);
            enterprise.setLongitude(longitude);
            enterpriseList.add(enterprise);
        
        }
        return enterprise;
    }
       
}
