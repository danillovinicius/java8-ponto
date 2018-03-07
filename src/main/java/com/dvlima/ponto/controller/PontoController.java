package com.dvlima.ponto.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dvlima.ponto.dto.RegistroDTO;
import com.dvlima.ponto.model.Registro;
import com.dvlima.ponto.service.RegistroService;

@RestController
@RequestMapping("api/v1/ponto")
public class PontoController {
	
	@Autowired
	private RegistroService service;

	@PostMapping("/incluir-registro")
	@ResponseStatus(value = HttpStatus.OK)
	public void incluirNovoRegistro(@RequestBody RegistroDTO dto) {
		service.save(dto);
	}
	
	@PostMapping("/incluir-lista")
	@ResponseStatus(value = HttpStatus.OK)
	public void incluirListaRegistro(@RequestBody List<RegistroDTO> registros) {
		service.save(registros);
	}
	
	@GetMapping("/listar")
	public List<String> listarTodos(){
		List<Registro> registros = service.findAll(); 
		return registros.stream().map(registro -> registro.toString()).collect(Collectors.toList());
	}
	
	@PostMapping("/remove/dia")
	@ResponseStatus(value = HttpStatus.OK)
	public void removerRegistroPontoPorData(@RequestBody RegistroDTO dto){
		service.removerRegistrosPontoPorData(dto.getData());
	}
	
	@PostMapping("/go-home")
	@ResponseStatus(value = HttpStatus.OK)
	public void calculaHoraDeSaida(@RequestBody RegistroDTO dto){
		service.removerRegistrosPontoPorData(dto.getData());
	}
	
}
