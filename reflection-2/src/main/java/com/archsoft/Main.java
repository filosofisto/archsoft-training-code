package com.archsoft;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;


public class Main {

	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		
		p.setIdade(66);
		p.setNome("Maradona");
		
		Pessoa airton = new Pessoa();
		
		airton.setIdade(40);
		airton.setNome("Senna");
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(p);
		pessoas.add(airton);
		
		ExportadorXML exportadorXML = 
				new ExportadorXML();
		
		try {
			out.println(
					exportadorXML
							.cabecalho()
							.exportar(pessoas)
			);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//--------------------------------------------------------
		Veiculo v1 = new Veiculo("AAA5689", "23123134345", 2020);
		Veiculo v2 = new Veiculo("BCD7458", "304i8738327", 2019);
		Veiculo v3 = new Veiculo("DGR1597", "32178333487", 2017);
		Veiculo v4 = new Veiculo("XCF2374", "45868372488", 2010);

//		try {
//			out.println(
//					exportadorXML
//							.cabecalho()
//							.exportar(List.of(v1, v2, v3, v4))
//			);
//		} catch (Exception e) {
//			e.printStackTrace();
//		};
	}
}
