package com.uniritter.monitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uniritter.monitor.domain.Metrica;
import com.uniritter.monitor.domain.MetricaService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MonitorApplication.class)
public class MonitorApplicationTests {
	
	@Autowired
	MetricaService service;
	
	@Test
	public void contextLoads() {
	}
	
	public Metrica createNewMetrica() {
		Metrica metrica;
		String nome = "Test Name " + new Random().nextInt();
		
		metrica = service.createMetrica(nome);
		
		return metrica;
	}
	
	@Test
	public void createNewMetricGenerateId() {
		Metrica metrica = createNewMetrica();
		
		assertNotEquals(null, metrica.getId());		
	}
	
	@Test
	public void compareNewMetricByName() {
		Metrica metrica = createNewMetrica();
		
		Metrica metricaDB = service.getMetricas(metrica.getId().intValue()).get(0);
		
		assertEquals(metrica.getNome(), metricaDB.getNome());		
	}
	
	@Test
	public void retriveListWithMoreThanOneMetric() {
		createNewMetrica();
		createNewMetrica();
		
		List<Metrica> listMetrica = service.getMetricas(0);
		
		assertEquals(true, listMetrica.size() > 1);		
	}

}
