/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;


import Business.Order.OrderCatalog;
import Business.PatientSensor.Test;
import Business.PatientSensor.TestDirectory;
import Business.Person.Person;

/**
 *
 * @author shivam
 */
public class Patient extends Person {
   private String Gender;
   private String Dob;
   private String Address;
    private String Zip;
    private String Email;
    private String Area;
private String town;


    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getZip() {
        return Zip;
    }

    public void setZip(String Zip) {
        this.Zip = Zip;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
    private String Phone;
   private OrderCatalog orderCatalog;
  
   private TestDirectory testDir;


    public OrderCatalog getOrderCatalog() {
        return orderCatalog;
    }

    public void setOrderCatalog(OrderCatalog orderCatalog) {
        this.orderCatalog = orderCatalog;
    }
   public Patient()
   {super();
   orderCatalog = new OrderCatalog();
   testDir = new TestDirectory();
   }

    public TestDirectory getTestDir() {
        return testDir;
    }

    public void setTestDir(TestDirectory testDir) {
        this.testDir = testDir;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String Dob) {
        this.Dob = Dob;
    }
}
