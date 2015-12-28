/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Drug.Drug;

/**
 *
 * @author shivam
 */
public class OrderItem {
     private String itemName;
    private int quantity;
    private int salePrice;
    private Drug drug;
    private int Volume;

    public int getVolume() {
        return Volume;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public void setVolume(int Volume) {
        this.Volume = Volume;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

   
public OrderItem()
{
drug = new Drug();
}

    @Override
    public String toString() {
        return drug.getDrugName();
    }


}
