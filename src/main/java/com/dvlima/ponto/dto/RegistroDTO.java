package com.dvlima.ponto.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.dvlima.ponto.enumeration.TipoRegistroEnum;
import com.dvlima.ponto.model.Registro;

public class RegistroDTO {
	
	private Long id;
	
	private LocalDateTime registroPonto;
	
	private LocalDate data;
	
	private LocalTime horario;
	
	private TipoRegistroEnum tipoPonto;

	public RegistroDTO() {
		super();
	}
	
	public RegistroDTO(LocalTime horario) {
		this.horario = horario;
	}

	public RegistroDTO(Registro entity) {
		setId(entity.getId());
		setData(entity.getData());
		setHorario(entity.getHorario());
	}
	
	public Registro getEntity() {
		Registro registro = new Registro();
		registro.setId(id);
		registro.setData(this.getData());
		registro.setHorario(horario);
		registro.setRegistroPonto(this.getRegistroPonto());
		registro.setTipoPonto(tipoPonto);
		return registro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getRegistroPonto() {
		this.registroPonto = LocalDateTime.of(this.getData(), this.getHorario()); 
		return this.registroPonto;
	}

	public void setRegistroPonto(LocalDateTime registroPonto) {
		this.registroPonto = registroPonto;
	}

	public LocalDate getData() {
		if(data == null) {
			data = LocalDate.now();
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

}
