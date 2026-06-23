/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzaria.forma;

/**
 *
 * @author letic
 */
public class Triangle extends Forma{
    public Triangle(double dimension){
        super(dimension);
        
        if (dimension < 20 || dimension > 23){
            throw new IllegalArgumentException(
                "INVALID DIMENSION: The dimension of a square pizza must be between 10 and 40 cm"
            );
        }
    }
    
    @Override
    public double getArea() {
        return Math.pow(dimensao, 2)* Math.sqrt(3) / 4;
    }
}
