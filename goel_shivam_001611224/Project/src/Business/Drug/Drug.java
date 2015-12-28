/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Drug;

/**
 *
 * @author shivam
 */
public class Drug {
    private String DrugName;
    private int id;
    private int salesPrice;
    
    private int Quantity;
    private String ExpirationDate;
    private int dosage;
    private  String Color;
    private String Type;
    private String odor;
    private String SaltName;
    private int MarketPrice;

    public int getMarketPrice() {
        return MarketPrice;
    }

    public void setMarketPrice(int MarketPrice) {
        this.MarketPrice = MarketPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(int salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getDrugName() {
        return DrugName;
    }

    public void setDrugName(String DrugName) {
        this.DrugName = DrugName;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getExpirationDate() {
        return ExpirationDate;
    }

    public void setExpirationDate(String ExpirationDate) {
        this.ExpirationDate = ExpirationDate;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getOdor() {
        return odor;
    }

    public void setOdor(String odor) {
        this.odor = odor;
    }

    public String getSaltName() {
        return SaltName;
    }

    public void setSaltName(String SaltName) {
        this.SaltName = SaltName;
    }
    @Override
    public String toString() {
        return  DrugName ;
    }
    
}
