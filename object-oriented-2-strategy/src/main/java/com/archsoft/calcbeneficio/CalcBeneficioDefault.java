package com.archsoft.calcbeneficio;

import com.archsoft.Funcionario;

public class CalcBeneficioDefault extends CalcBeneficioStrategy {

    public static final double TAXA_PADRAO = 0.15;

    @Override
    public double calculaBeneficio(Funcionario funcionario, double... outrosValores) {
        return funcionario.getSalario() * TAXA_PADRAO;
    }
}
