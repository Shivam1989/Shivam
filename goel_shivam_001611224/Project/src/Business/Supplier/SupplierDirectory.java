/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Supplier;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shivam
 */
public class SupplierDirectory {
    private List<Supplier> supplierList;
    public SupplierDirectory() {
       supplierList = new ArrayList<Supplier>();
    }
    
    public List<Supplier> getSupplierlist(){
        return supplierList;
    }
    
    public Supplier addSupplier(){
        Supplier s = new Supplier();
        

        supplierList.add(s);
        return s;
    }
    
    public void removeSupplier(Supplier s){
        supplierList.remove(s);
    }
    
    
}
