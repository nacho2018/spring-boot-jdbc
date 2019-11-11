package com.springboot.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springboot.jdbc.models.Cliente;

@Repository
public class ClienteDaoImpl  implements ClienteDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public List<Cliente> findAll(){
		return this.jdbcTemplate.query("select * from clientes", new ClienteMapper());
	}
	
	public int numClientes() {
		
		return this.jdbcTemplate.queryForObject("select count(*) from clientes", Integer.class);
	}
	
	private static final class ClienteMapper implements RowMapper<Cliente> {

	    public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	Cliente cliente = new Cliente();
	    	cliente.setId(rs.getInt("id"));
	       cliente.setNombre(rs.getString("nombre"));
	       cliente.setApellido(rs.getString("apellido"));
	        return cliente;
	    }
	}
	
	
}
