package com.archsoft;


import static java.lang.System.out;

public class Main {

	public static void main(String[] args) {
//		Pessoa p = new Pessoa();
//		p.setNome("Maradona");
//		p.setIdade(-1);


		try {
			Pessoa p = createPessoa();
		} catch (Exception e) {
			e.printStackTrace();
		}

//		try {
//			p.setIdade(-1);
//		} catch (Exception e) {
//			out.println("Sr usuario lamento mas a idade nao eh valida");
//		}
	}

	static Pessoa createPessoa() throws Exception {
		Pessoa p = new Pessoa();

		p.setNome("Maradona");
		p.setIdade(70);

		return p;
	}
}
