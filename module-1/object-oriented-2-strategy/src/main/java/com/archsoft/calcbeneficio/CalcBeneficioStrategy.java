package com.archsoft.calcbeneficio;

import com.archsoft.Funcionario;

public abstract class CalcBeneficioStrategy {

    public abstract double calculaBeneficio(Funcionario funcionario, double... outrosValores);
}
