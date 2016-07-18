package com.uniritter.monitor.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.uniritter.monitor.domain.Metrica;

public class MetricaRowMapper implements RowMapper<Metrica> {

	@Override
	public Metrica mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Metrica(
				rs.getLong("id"), 
				rs.getString("nome"),
				rs.getDate("created"));
	}
	
}
