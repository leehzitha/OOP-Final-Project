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
    private Status orderStatus;

    public Order(Client client, Pizza pizza, int id){
        this.client = client;
        this.id = id;
        this.pizzas.add(pizza);
        client.newOrder(this);
        this.orderStatus = Status.ABERTO;
    }

    public Status getOrderStatus() {
        return this.orderStatus;
    }
    
    public void setOrderStatus(Status status){
        if (status == Status.ABERTO &&
            (orderStatus == Status.ENTREGUE || orderStatus == Status.A_CAMINHO)) {
            throw new IllegalStateException("Pedido entregue não pode voltar para aberto.");
        }
        this.orderStatus = status;
    }
    
    public void addPizza(Pizza pizza, PriceTable priceTable){
        this.pizzas.add(pizza);
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
        double total = 0;

        for(Pizza pizza : pizzas){
            total += pizza.getPrice(priceTable);
        }

        return total;
    }
}
