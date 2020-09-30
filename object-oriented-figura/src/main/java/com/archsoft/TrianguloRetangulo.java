package com.archsoft;

public class TrianguloRetangulo extends Retangulo {

    @Override
    public double perimetro() {
        return base + altura + Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
    }

    @Override
    public double area() {
        return super.area() / 2;
    }
}
