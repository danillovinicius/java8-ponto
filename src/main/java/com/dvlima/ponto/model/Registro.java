package com.dvlima.ponto.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.dvlima.ponto.enumeration.TipoRegistroEnum;

@Entity
@Table(name = "TB_REGISTRO")
public class Registro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private LocalDateTime registroPonto;

	@NotNull(message = "O campo data não pode ser nulo")
	private LocalDate data;
	
	@NotNull(message = "O campo horario não pode ser nulo")
	private LocalTime horario;

	private TipoRegistroEnum tipoPonto;
	
	public Registro() {
		super();
	}

	public Registro(@NotNull(message = "O campo data não pode ser nulo") LocalDate data,
			@NotNull(message = "O campo horario não pode ser nulo") LocalTime horario) {
		super();
		this.data = data;
		this.horario = horario;
		this.setRegistroPonto(LocalDateTime.of(data, horario));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getRegistroPonto() {
		return registroPonto;
	}

	public void setRegistroPonto(LocalDateTime registroPonto) {
		this.registroPonto = registroPonto;
	}

	public LocalDate getData() {
		if(data == null) {
			
		}
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public TipoRegistroEnum getTipoPonto() {
		return tipoPonto;
	}

	public void setTipoPonto(TipoRegistroEnum tipoPonto) {
		this.tipoPonto = tipoPonto;
	}

	@Override
	public String toString() {
		return this.getRegistroPonto().toString();
	}
	
	
}
