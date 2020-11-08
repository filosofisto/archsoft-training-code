package com.archsoft;

public class Main {

    public static void main(String[] args) {
        // Apenas um cafezinho
        Product cafezinho = new Cofee();
        cafezinho.show();

        Product copoLeite = new Milke();
        copoLeite.show();

        Product cafeComLeite = new Cofee(new Milke());
        cafeComLeite.show();

        Product cafeComLeiteAcucar = new Cofee(new Milke(new Sugar()));
        cafeComLeiteAcucar.show();

        Product espresso = new CofeeEspresso(new Sugar());
        espresso.show();
    }
}
