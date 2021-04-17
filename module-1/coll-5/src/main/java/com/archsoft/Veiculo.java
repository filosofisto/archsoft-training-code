package com.archsoft;

public class Veiculo {

    private Integer renavam;
    private String marca;
    private String fabricante;

    public Veiculo(Integer renavam) {
        this.renavam = renavam;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Veiculo) {
            Veiculo other = (Veiculo) obj;

            return renavam.equals(other.renavam);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return getRenavam().hashCode();
    }

    public Integer getRenavam() {
        return renavam;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
}
