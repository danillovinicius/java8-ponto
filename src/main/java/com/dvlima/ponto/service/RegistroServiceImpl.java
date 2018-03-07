package com.dvlima.ponto.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvlima.ponto.dto.RegistroDTO;
import com.dvlima.ponto.enumeration.TipoRegistroEnum;
import com.dvlima.ponto.model.Registro;
import com.dvlima.ponto.repository.RegistroRepository;

@Service
@Transactional
public class RegistroServiceImpl implements RegistroService {

	@Autowired
	private RegistroRepository repository;

	@Override
	public List<Registro> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(RegistroDTO dto) {
		configurarTipoDeRegistro(dto);
		repository.save(dto.getEntity());
	}

	private void configurarTipoDeRegistro(RegistroDTO dto) {
		List<Registro> registrosNoDia = obterRegistrosPelaData(dto.getData());

		TipoRegistroEnum tipoPonto = TipoRegistroEnum.E;

		if (!registrosNoDia.isEmpty() && tipoPonto.equals(obterUltimoTipoRegistroPonto(registrosNoDia))) {
			tipoPonto = TipoRegistroEnum.S;
		}

		dto.setTipoPonto(tipoPonto);
	}

	private List<Registro> obterRegistrosPelaData(LocalDate data) {
		return repository.obterRegistrosPelaData(data);
	}

	private TipoRegistroEnum obterUltimoTipoRegistroPonto(List<Registro> registrosNoDia) {
		return registrosNoDia.stream().sorted(Comparator.comparing(Registro::getHorario).reversed())
				.map(registro -> registro.getTipoPonto()).collect(Collectors.toList()).get(0);
	}

	@Override
	public void save(List<RegistroDTO> lista) {
		lista.stream().sorted(Comparator.comparing(RegistroDTO::getRegistroPonto)).collect(Collectors.toList())
				.forEach(this::save);
	}

	@Override
	public void removerRegistrosPontoPorData(LocalDate data) {
		repository.removerRegistrosPontoPorData(data);
	}

	@Override
	public RegistroDTO calculaHorarioSaida(LocalDate data) {
		 
		List<Registro> registrosNoDia = obterRegistrosPelaData(data);
		
		if(!registrosNoDia.isEmpty() && registrosNoDia.size() > 3) {
			LocalDateTime chegada = registrosNoDia.get(0).getRegistroPonto();
			LocalDateTime almoco = registrosNoDia.get(1).getRegistroPonto();
			LocalDateTime retorno = registrosNoDia.get(2).getRegistroPonto();
			
            Duration dur = Duration.between(chegada, almoco);
            long millis = dur.toMillis();

            String.format("%02d:%02d:%02d", 
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis) - 
                    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - 
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
			
		}
		
		return null;
	}
	
	
}
