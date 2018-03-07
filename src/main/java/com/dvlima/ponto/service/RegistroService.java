package com.dvlima.ponto.service;

import java.time.LocalDate;
import java.util.List;

import com.dvlima.ponto.dto.RegistroDTO;
import com.dvlima.ponto.model.Registro;

public interface RegistroService {

	List<Registro> findAll();

	void save(RegistroDTO dto);
	
	void save(List<RegistroDTO> lista);

	void removerRegistrosPontoPorData(LocalDate data);
	
	RegistroDTO calculaHorarioSaida(LocalDate data);
}
