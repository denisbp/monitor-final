package com.uniritter.monitor.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.uniritter.monitor.domain.Metrica;

@Component
public class MetricaDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MetricaDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Metrica getMetrica(Long id) {
		return this.jdbcTemplate
			.queryForObject(
				"select * from metrica where id = ?", 
				new MetricaRowMapper(), id);
	}
	
	public List<Metrica> getMetricas() {
		return this.jdbcTemplate
			.query(
				"select * from metrica order by id", 
				new MetricaRowMapper());
	}

	public int createMetrica(final Metrica metrica) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
	        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	            PreparedStatement ps =
	                connection.prepareStatement("insert into metrica (name,created) values (?,?)", new String[] {"id"});
	            ps.setString(1, metrica.getNome());
	            ps.setDate(2, new java.sql.Date(metrica.getCreated().getTime()));
	            return ps;
	        }
	    }, keyHolder);
		
		return keyHolder.getKey().intValue();
	}
	
}
