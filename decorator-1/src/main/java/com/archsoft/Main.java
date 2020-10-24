package com.archsoft;

public class Main {

    public static void main(String[] args) {
        // Apenas um cafezinho
        Product cafezinho = new Cofee();
        cafezinho.showPrice();

        Product copoLeite = new Milke();
        copoLeite.showPrice();

        Product cafeComLeite = new Cofee(new Milke());
        cafeComLeite.showPrice();

        Product cafeComLeiteAcucar = new Cofee(new Milke(new Sugar()));
        cafeComLeiteAcucar.showPrice();

        Product espresso = new CofeeEspresso(new Sugar());
        espresso.showPrice();
    }
}
