package com.dvlima.ponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvlima.ponto.model.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Long>, RegistroRepositoryCustom {

}
