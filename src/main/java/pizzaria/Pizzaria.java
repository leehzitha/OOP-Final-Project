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
import javax.swing.JFrame;
import pizzaria.model.Flavour;
import pizzaria.view.Home;

/**
 *
 * @author letic
 * @author Vinicius Dias
 */
public class Pizzaria {
    private ArrayList<Order> orders;
    private ArrayList<Client> clients;
    private PriceTable priceTable;
    private ArrayList<Flavour> flavoursList;

    public Pizzaria(){
        this.orders = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.priceTable = new PriceTable();
        this.flavoursList = new ArrayList<>();
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
    
    public ArrayList<Flavour> getFlavoursList(){
        return flavoursList;
    }

    public void newOrder(Client client, ArrayList<Pizza> pizzas, double subtotal){
        if (!clients.contains(client)) {
            throw new NoSuchElementException("Cliente inexistente");
        }
        int id = orders.size(); //id sequencial
        Order order = new Order(client, pizzas, subtotal, id);
        
        this.orders.add(order);
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
            if (o.getClient().equals(client) && o.getOrderStatus().equalsIgnoreCase("ABERTO")) {
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
    
    public void deleteFlavour(Flavour flavour) {
        if (flavour == null || flavour.getName() == null) {
            return;
        }
        this.flavoursList.removeIf(f -> f.getName().equalsIgnoreCase(flavour.getName().trim()));
    }

    public static void main(String[] args) {
        Pizzaria pizzaria = new Pizzaria();
        JFrame screen = new JFrame("Pizzaria - Sistema de Cadastro");
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setSize(800, 600);
        screen.setLocationRelativeTo(null);

        Home telaHome = new Home(pizzaria);
//        SignupClient telaCadastro = new SignupClient( pizzaria , -1, null); // -1 == cadastro de cliente;
//        screen.add(telaCadastro);
        screen.add(telaHome);
        screen.setVisible(true);
    }


}
