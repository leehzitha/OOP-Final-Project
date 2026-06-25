    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package pizzaria.model;

    /**
     *
     * @author letic
     */
    public class PriceTable {
        private double simplePrice = 0.08;
        private double specialPrice = 0.12;
        private double premiumPrice = 0.18;

        public double getSimplePriceBase() { return simplePrice; }
        public double getSpecialPriceBase() { return specialPrice; }
        public double getPremiumPriceBase() { return premiumPrice; }

        public double getSimplePrice(Pizza pizza){
            if (pizza.getFlavourQuantity() == 0)
                return 0.0;

            return pizza.getArea() * simplePrice;
        }

        public double getSpecialPrice(Pizza pizza){
            if (pizza.getFlavourQuantity() == 0)
                return 0.0;

            return pizza.getArea() * specialPrice;
        }

        public double getPremiumPrice(Pizza pizza){
            if (pizza.getFlavourQuantity() == 0)
                return 0.0;
            return pizza.getArea() * premiumPrice;
        }
        
        public void updatePrice(PizzaType type, double newPrice) {
            switch (type) {
                case Simple -> this.simplePrice = newPrice;
                case Special -> this.specialPrice = newPrice;
                case Premium -> this.premiumPrice = newPrice;
            }
        }
    }
