package pizzaria.forma;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author letic
 */
public abstract class Forma {
    protected double dimensao;
    
    public Forma(double dimensao){
        this.dimensao = dimensao;
    };
    public abstract double getArea();
}
