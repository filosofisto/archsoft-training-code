package com.archsoft.calcbeneficio;

import com.archsoft.Funcionario;

public class CalcBeneficioGerente extends CalcBeneficioStrategy {

    @Override
    public double calculaBeneficio(Funcionario funcionario, double... outrosValores) {
        return (funcionario.getSalario() + outrosValores[0]) * 0.25;
    }
}
