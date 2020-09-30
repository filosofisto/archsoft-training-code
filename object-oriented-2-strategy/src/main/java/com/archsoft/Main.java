package com.archsoft;

import com.archsoft.calcbeneficio.CalcBeneficioDefault;
import com.archsoft.calcbeneficio.CalcBeneficioDiretor;
import com.archsoft.calcbeneficio.CalcBeneficioGerente;
import com.archsoft.calcbeneficio.CalcBeneficioStrategy;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        Funcionario normal = new Funcionario("Eduardo", 30, 12000);
        normal.setCalcBeneficioStrategy(new CalcBeneficioDefault());

        Funcionario gerente = new Funcionario("Douglas", 45, 30000);
        gerente.setCalcBeneficioStrategy(new CalcBeneficioGerente());

        Funcionario diretor = new Funcionario("Juvenal", 62, 150000);
        diretor.setCalcBeneficioStrategy(new CalcBeneficioDiretor());

        out.printf("Beneficio do funcionario: %s -> %.2f\n",
                normal.getNome(), normal.calcBeneficio());
        out.printf("Beneficio do gerente    : %s -> %.2f\n",
                gerente.getNome(), gerente.calcBeneficio(5000));
        out.printf("Beneficio do diretor    : %s -> %.2f\n",
                diretor.getNome(), diretor.calcBeneficio(8000));
    }
}
