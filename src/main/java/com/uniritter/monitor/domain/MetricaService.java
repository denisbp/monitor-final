package com.uniritter.monitor.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MetricaService {
	
	@Autowired
	MetricaRepository repository;
	
	public List<Metrica> getMetricas(int id) {
		
		return (id <= 0) ? repository.getMetricas() : repository.getMetrica(id);
		
	}

	public Metrica createMetrica(String nomeMetrica) {
		
		return repository.createMetrica(nomeMetrica);
		
	}
	
	
}
