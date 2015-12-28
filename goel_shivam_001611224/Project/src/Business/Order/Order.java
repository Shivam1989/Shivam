/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Drug.Drug;
import java.util.ArrayList;

/**
 *
 * @author shivam
 */
public class Order {
    private ArrayList<OrderItem> orderItemlist;
    private int orderNumber;
    private static int count =0;
    
    public Order()
    {
       count++;
       orderNumber = count;
       orderItemlist = new ArrayList<OrderItem>();
      
       
       
    } 

    
    public ArrayList<OrderItem> getOrderItemlist() {
        return orderItemlist;
    }

    public void setOrderItemlist(ArrayList<OrderItem> orderItemlist) {
        this.orderItemlist = orderItemlist;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    public  void removeorderItem(Order item)
    {orderItemlist.remove(item);
    
    }
    
    public OrderItem addOrderItem(int quantity, int price, Drug d)
            
    {OrderItem item = new OrderItem();
    int volume=quantity*price;
    item.setDrug(d);
    item.setQuantity(quantity);
    item.setSalePrice(price);
    item.setVolume(volume);
            
        orderItemlist.add(item);
        
        return item;
            }
    
}
