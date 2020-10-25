package com.archsoft;

import com.archsoft.entity.Evento;
import com.archsoft.entity.Modalidade;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("jpa-01");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Query existsModalidade = entityManager.createQuery(
            		"select count(m) from Modalidade m");

			boolean exists = Optional.ofNullable(existsModalidade.getSingleResult())
					.map(singleResult -> ((Long) singleResult).longValue() > 0)
					.orElse(false);

			if (!exists) {
				Modalidade m1 = new Modalidade();
				m1.setNome("Atletismo");

				entityManager.persist(m1);

				Modalidade m2 = new Modalidade();
				m2.setNome("Natacao");

				entityManager.persist(m2);

				Evento e1 = new Evento();
				e1.setDataOficio(new Date());
				e1.setJustificativa("Sem justificativa");
				e1.setLocal("Nenhum");
				e1.setModalidades(List.of(m1, m2));
				e1.setNome("Campeonato Mundial");
				e1.setObjetivo("Ser campeao");
				e1.setPeriodoInicio(
						Date.from(
								LocalDate.of(2020, 11, 30)
										.atStartOfDay()
										.atZone(ZoneId.systemDefault())
										.toInstant()
						)
				);
				e1.setPeriodoFim(
						Date.from(
								LocalDate.of(2020, 12, 31)
										.atStartOfDay()
										.atZone(ZoneId.systemDefault())
										.toInstant()
						)
				);
				entityManager.persist(e1);

				Evento e2 = new Evento();
				e2.setDataOficio(new Date());
				e2.setJustificativa("Injusticavel");
				e2.setLocal("Sao Paulo");
				e2.setModalidades(List.of(m1, m2));
				e2.setNome("Campeonato Brasileiro Paralimpico");
				e2.setObjetivo("Ser campeao");
				e2.setPeriodoInicio(
						Date.from(
								LocalDate.of(2020, 1, 1)
										.atStartOfDay()
										.atZone(ZoneId.systemDefault())
										.toInstant()
						)
				);
				e2.setPeriodoFim(
						Date.from(
								LocalDate.of(2020, 1, 30)
										.atStartOfDay()
										.atZone(ZoneId.systemDefault())
										.toInstant()
						)
				);
				entityManager.persist(e2);
			}

			TypedQuery<Modalidade> queryAtletismo = entityManager.createQuery(
					"select m from Modalidade m where m.nome = 'Atletismo'",
					Modalidade.class);
			Modalidade atletismo = queryAtletismo.getSingleResult();

			Optional.ofNullable(atletismo)
					.ifPresent(modalidade -> modalidade.getEventos().stream().forEach(out::println));

			Evento evento = entityManager.createQuery(
					"select e from Evento e where e.id = (select max(e2.id) from Evento e2)",
					Evento.class)
					.getSingleResult();
			Optional.ofNullable(evento)
					.map(e -> e.getModalidades())
					.ifPresent(modalidades -> modalidades.forEach(out::println));

			transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
