package pizzaria.model;


import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author letic
 */
public class Order {
    private int id;
    private Client client;
    private ArrayList<Pizza> pizzas = new ArrayList<>();
    private double subtotal = 0.0;
    private String orderStatus;

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    public Order(Client client, Pizza pizza, int id){
        this.client = client;
        this.id = id;
        this.pizzas.add(pizza);
        client.newOrder(this);
        this.orderStatus = "PENDING";
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }
    
    public void setOrderStatus(String status){
        String[] immutableStatus = {"ENTREGUE", "A CAMINHO"};
        if ( status == "ABERTO" && !Arrays.asList(immutableStatus).contains(this.getOrderStatus()) ){
            this.orderStatus = "ABERTO";
        } else {
            this.orderStatus = status;
        }
    }
    
    public void addPizza(Pizza pizza, PriceTable priceTable){
        this.pizzas.add(pizza);
        this.subtotal += pizza.getPrice(priceTable);
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
            this.subtotal += pizza.getPrice(priceTable);
        }
       return this.subtotal;
    }
}
