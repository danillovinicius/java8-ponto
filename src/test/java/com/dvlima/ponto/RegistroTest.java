package com.dvlima.ponto;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.dvlima.ponto.dto.RegistroDTO;
import com.dvlima.ponto.model.Registro;
import com.dvlima.ponto.repository.RegistroRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RegistroTest {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private RegistroRepository repository;

	@Test
	public void testarInclusaoRegistros() {
		RegistroDTO dto = new RegistroDTO();
		dto.setHorario(LocalTime.now());

		Registro mock = this.entityManager.persist(dto.getEntity());
		Optional<Registro> registro = this.repository.findById(mock.getId());
		assertThat(registro.get().getRegistroPonto()).isEqualTo(dto.getRegistroPonto());
	}

	@Test
	public void testarOrdenacaoListaRegistros() {
		LocalDate data = LocalDate.of(2018, 03, 7);

		List<Registro> registros = new ArrayList<>();
		registros.add(new Registro(data, LocalTime.of(18, 15)));
		registros.add(new Registro(data, LocalTime.of(8, 15)));
		registros.add(new Registro(data, LocalTime.of(13, 3)));
		registros.add(new Registro(data, LocalTime.of(12, 1)));

		List<Registro> orderedASC = registros.stream().sorted(Comparator.comparing(Registro::getHorario))
				.collect(Collectors.toList());

		List<Registro> orderedDESC = registros.stream().sorted(Comparator.comparing(Registro::getHorario).reversed())
				.collect(Collectors.toList());

		assertThat(registros.get(1).getRegistroPonto()).isEqualTo(orderedASC.get(0).getRegistroPonto());
		
		assertThat(registros.get(0).getRegistroPonto()).isEqualTo(orderedDESC.get(0).getRegistroPonto());
	}

}
