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

    public Forma getForma() {
        return forma;
    }
    private Flavour[] flavours = new Flavour[2];
    private double price = 0.00;
   
    public double getPrice(PriceTable priceTable) {
        double precoAcumulado = 0.0;
        int saboresContados = 0;

        for (Flavour flavour : flavours) {
            if (flavour != null){
                saboresContados++;
                switch (flavour.getType()) {
                    case Simple:
                        precoAcumulado += priceTable.getSimplePrice(this);
                        break;
                    case Special:
                        precoAcumulado += priceTable.getSpecialPrice(this);
                        break;
                    case Premium:
                        precoAcumulado += priceTable.getPremiumPrice(this);
                        break;
                    default: 
                        break;
                }
            }
        }

        if (saboresContados > 0) {
            this.price = precoAcumulado / saboresContados;
        } else {
            this.price = 0.00;
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
    
    public void setForma(Forma forma) {
        this.forma = forma;
    }

    public void setFlavours(Flavour[] flavours) {
        this.flavours = flavours;
    }
}

