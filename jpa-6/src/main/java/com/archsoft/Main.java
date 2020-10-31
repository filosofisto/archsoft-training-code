package com.archsoft;

import com.archsoft.entity.Funcionario;
import com.archsoft.entity.Pessoa;

import javax.persistence.*;
import java.util.List;

import static java.lang.System.out;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("jpa-01");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			
			Pessoa p = new Pessoa();
			p.setNome("Jose da Silva");
			entityManager.persist(p);
			
			Funcionario f = new Funcionario();
			f.setNome("Joao Trabalhador");
			f.setSalario(10000.0);
			entityManager.persist(f);

			TypedQuery<Pessoa> pessoasQuery = entityManager
					.createQuery("select p from Pessoa p", Pessoa.class);

			List<Pessoa> pessoas = pessoasQuery.getResultList();

			pessoas.forEach(System.out::println);
			out.println("Pessoas: " + pessoas.size());

			TypedQuery<Funcionario> funcionariosQuery = entityManager
					.createQuery("select f from Funcionario f", Funcionario.class);
			List<Funcionario> funcionarios = funcionariosQuery.getResultList();

			funcionarios.forEach(out::println);
			out.println("Funcionarios: " + funcionarios.size());
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
