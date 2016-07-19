package com.uniritter.monitor.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uniritter.monitor.persistence.MetricaDao;

@Component
public class MetricaRepository {
	
	@Autowired
	MetricaDao metricaDao;
	
	public List<Metrica> getMetricas() {
		return this.metricaDao.getMetricas();
	}
	
	public List<Metrica> getMetrica(long id) {
		List<Metrica> list = new ArrayList<Metrica>();
		list.add(this.metricaDao.getMetrica(id));
		return list;
	}

	public Metrica createMetrica(String nomeMetrica) {
		
		Metrica nova = new Metrica(
				null,
				nomeMetrica, new Date());
		nova.setId((long)metricaDao.createMetrica(nova));
		return nova;
	}

}
