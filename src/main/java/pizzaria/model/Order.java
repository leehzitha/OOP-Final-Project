package pizzaria.model;


import pizzaria.model.Client;
import pizzaria.model.Pizza;
import java.util.ArrayList;
/**
 *
 * @author letic
 */
public class Order {
    private int id;
    private Client client;
    private ArrayList<Pizza> pizzas = new ArrayList<>();
    private double price = 0.0;
    
    public Order(Client client, Pizza pizza, int id){
        this.client = client;
        this.id = id;
        this.pizzas.add(pizza);
        client.newOrder(this);
    }
    
    public void addPizza(Pizza pizza, PriceTable priceTable){
        this.pizzas.add(pizza);
        this.price += pizza.getPrice(priceTable);
    }
    
    public int getId(){
        return this.id;
    }
    
    public Client getClient(){
        return this.client;
    }
    
    public ArrayList<Pizza> getPizzas() {
        return this.pizzas;
    }
    
    public double getPrice(PriceTable priceTable){
        for (Pizza pizza : pizzas){
            this.price += pizza.getPrice(priceTable);
        }
       return this.price;
    }
}
