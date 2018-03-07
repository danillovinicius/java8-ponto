package com.dvlima.ponto.repository;

import java.time.LocalDate;
import java.util.List;

import com.dvlima.ponto.model.Registro;

public interface RegistroRepositoryCustom {
	void removerRegistrosPontoPorData(LocalDate data);
	
	List<Registro> obterRegistrosPelaData(LocalDate data);
}
