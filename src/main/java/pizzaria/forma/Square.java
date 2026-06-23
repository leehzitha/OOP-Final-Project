package pizzaria.forma;


import pizzaria.forma.Forma;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author letic
 */
public class Square extends Forma{
    public Square(double dimensao){
        super(dimensao);
        
        if (dimensao < 10 || dimensao > 40){
            throw new IllegalArgumentException(
                "INVALID DIMENSION: The dimension of a square pizza must be between 10 and 40 cm"
            );
        }
    }
    
    @Override
    public double getArea(){
        return Math.pow(dimensao, 2);
    };
    
    
}   
