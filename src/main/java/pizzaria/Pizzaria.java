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
import pizzaria.view.SignupClient;
import javax.swing.JFrame;

/**
 *
 * @author letic
 * @author Vinicius Dias
 */
public class Pizzaria {
    private ArrayList<Order> orders;
    private ArrayList<Client> clients;
    private PriceTable priceTable;

    public Pizzaria(){
        this.orders = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.priceTable = new PriceTable();
    }
    
    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<Order> getOrdersList() {
        return orders;
    }

    public PriceTable getPriceTable() {
        return priceTable;
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

    public String getOrdersToStr(){
        String result = "";
        for (Order order : this.orders) {
            result += order.getId() + "  "
                    +  order.getClient().getName() + "  "
                    + order.getPrice(this.priceTable);
        }
        return result;
    }
    
    public Client findClientByTelephone(String telephone) {
        for (Client c : clients) {
            if (c.getTelephone().equals(telephone.trim())) {
                return c;
            }
        }
        return null;
    }
    
    public Order findActiveOrderByClient(Client client) {
        for (Order o : orders) {
            //btsca um pedido daquele cliente que ainda esteja com status em aberto "PENDING"
            if (o.getClient().equals(client) && o.getOrderStatus().equalsIgnoreCase("PENDING")) {
                return o;
            }
        }
        return null;
    }
    
    public void deleteClientWithOrders(Client client) {
        //rem todos os pedidos que pertencem ao cliente
        orders.removeIf(order -> order.getClient().equals(client));
        clients.remove(client);
    }

    public static void main(String[] args) {
        Pizzaria pizzaria = new Pizzaria();
        JFrame screen = new JFrame("Pizzaria - Sistema de Cadastro");
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setSize(800, 600);
        screen.setLocationRelativeTo(null);

        SignupClient telaCadastro = new SignupClient( pizzaria , -1, null); // -1 == cadastro de cliente
        screen.add(telaCadastro);

        screen.setVisible(true);
    }


}
