package pizzaria.model;


import pizzaria.model.Flavour;
import pizzaria.forma.Forma;
import java.util.List;
import pizzaria.model.PriceTable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author letic
 */
public class Pizza {
    private Forma forma;
    private Flavour[] flavours = new Flavour[2];
    private double price = 0.00;
    
   
    public double getPrice(PriceTable priceTable){
        for (Flavour flavour : flavours){
            switch (flavour.getType()) {
                case Simple:
                    this.price += priceTable.getSimplePrice(this);
                    break;
                case Special:
                    this.price += priceTable.getSpecialPrice(this);
                    break;
                case Premium:
                    this.price += priceTable.getPremiumPrice(this);
                    break;
                default: break;
            }
        }
        return this.price;  
    }
    
    public double getArea(){
        return this.forma.getArea();
    }
    
    public int getFlavourQuantity(){
        int qtde = 0;
        for (int i = 0; i < 2; i ++){
            if (flavours[i] != null)
                qtde ++;
        }
        
        if (qtde == 0)
            return 0;
        return qtde;
    }
}

