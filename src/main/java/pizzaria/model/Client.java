package pizzaria.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
/**
 *
 * @author Vinicius Dias
 */
public class Client {

    private String name;
    private String lastname;
    private String telephone;
    private String adress;
    private ArrayList<Order> orders = new ArrayList();

    public Client (String name, String lastname, String telephone) {
        this.name = name;
        this.lastname = lastname;
        this.telephone = telephone;
    }

    //getters e setters
    public String getName() { return name;}
    public void setName(String name) {this.name = name;}

    public String getLastname() { return lastname;}
    public void setLastname(String lastname) {this.lastname = lastname;}

    public String getTelephone() { return telephone;}
    public void setTelephone(String telephone) {this.telephone = telephone;}

    public String getAdress() { return adress; }
    public void setAdress(String adress) { this.adress = adress; }
    
    public void newOrder(Order order){
        orders.add(order);
    }

    @Override
    public String toString() {
        return name + " " + lastname + " - " + telephone;
    }
}
