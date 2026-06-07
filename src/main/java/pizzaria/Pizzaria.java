/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pizzaria;
import java.util.ArrayList;
import pizzaria.model.Pizza;
import pizzaria.model.Client;
import pizzaria.model.Order;
import pizzaria.model.PriceTable;
import java.util.NoSuchElementException;

/**
 *
 * @author letic
 */
public class Pizzaria {
    private ArrayList<Order> orders;
    private ArrayList<Client> clients;
    private PriceTable priceTable;

    
    public void addClient(Client client){
        this.clients.add(client);
    }
    
    public void newOrder(Client client, Pizza pizza){
        if (!clients.contains(client)) {
            throw new NoSuchElementException("Client not found");
        }
        int id = orders.size();
        Order order = new Order(client, pizza, id);
        client.newOrder(order);  
    }
    
    public void cancelOrder(Order order){
        if (!orders.contains(order)){
            throw new NoSuchElementException("Order not found");
        }
        orders.remove(order);
    }
    
    public String getOrders(){
        String result = "";
        for (Order order : this.orders) {
            result += order.getId() + "  "
                    +  order.getClient().getName() + "  "
                    + order.getPrice(this.priceTable);
        }
        return result;
    }
    
}
