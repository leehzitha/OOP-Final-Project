package pizzaria.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author letic
 */
public class Flavour {
    private PizzaType pizzaType;
    private String name;
    
    public Flavour(PizzaType pizzaType, String name){
        this.pizzaType = pizzaType;
        this.name = name;
    }
    
    public PizzaType getType(){
        return this.pizzaType;
    }
}
