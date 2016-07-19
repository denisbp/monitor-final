package com.uniritter.monitor.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uniritter.monitor.domain.Metrica;
import com.uniritter.monitor.domain.MetricaService;

@Component
@Produces("application/json")
@Consumes("application/json")
@Path("metricas")
public class MetricaController {
	
	@Autowired
	MetricaService service;
	
	@GET
	public Response getMetricas(@QueryParam("id") int id) {
		
		return Response
			.ok(service.getMetricas(id))
			.build();
	}
	
	@POST
	public Response createMetrica(Metrica metrica) {
		
		Metrica nova = service.createMetrica(metrica.getNome());
		
		return Response
				.accepted(nova)
				//.ok(nova)
				.build();
	}
	
	
}
