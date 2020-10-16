package com.archsoft;

public class Veiculo {

    private String placa;

    private String renavam;

    private int ano;

    public Veiculo(String placa, String renavam, int ano) {
        this.placa = placa;
        this.renavam = renavam;
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
