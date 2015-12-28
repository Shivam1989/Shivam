/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import java.util.ArrayList;

/**
 *
 * @author shivam
 */
public class OrderCatalog {
    private ArrayList<Order>OrderCatalog;
    public OrderCatalog()
    {
    OrderCatalog = new ArrayList<Order>();
    }  

    public ArrayList<Order> getOrderCatalog() {
        return OrderCatalog;
    }

    public void setOrderCatalog(ArrayList<Order> OrderCatalog) {
        this.OrderCatalog = OrderCatalog;
    }
    
    public Order addOrder(Order o)
    {
        
        OrderCatalog.add(o);
        return o;
    }
    
}
