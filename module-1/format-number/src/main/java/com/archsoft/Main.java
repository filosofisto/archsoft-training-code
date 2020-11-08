package com.archsoft;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import static java.lang.System.out;

public class Main {

	public static void main(String[] args) {
		NumberFormat fbr = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		NumberFormat fus = NumberFormat.getCurrencyInstance(Locale.US);
		NumberFormat perc = NumberFormat.getPercentInstance();

		out.println(perc.format(0.75));
		
		double valor = 10575.459543;
		
		out.println(fbr.format(valor));
		out.println(fus.format(valor));
		
		try {
			NumberFormat converter = NumberFormat.getInstance(Locale.US);
			
			String strValue = "10.589";
			Number number = converter.parse(strValue);
			
			out.printf("Valor: %.2f\n", number.floatValue());
			out.printf("Conversao de %s realizada com sucesso\n", strValue);

			String wrongValue = "xxxx";
			out.printf("Valor %.2f\n", converter.parse(wrongValue).floatValue());
			out.printf("Conversao de %s realizada com sucesso\n", wrongValue);
		} catch (ParseException e) {
			out.println("Erro ao converter para numero: " + e.getMessage());
		} 
	}
}
