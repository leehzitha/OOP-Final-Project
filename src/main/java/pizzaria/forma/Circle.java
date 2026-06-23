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
public class Circle extends Forma {
    public Circle(double dimension){
        super(dimension);
        
        if (dimension < 7 || dimension > 23){
            throw new IllegalArgumentException(
                "INVALID DIMENSION: The radius of a round pizza must be between 7 and 23 cm"
            );
        }
    }
    
    @Override
    public double getArea(){
        return Math.PI * Math.pow(dimensao, 2);
    };
}
