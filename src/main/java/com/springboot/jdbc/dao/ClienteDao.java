package com.springboot.jdbc.dao;

import java.util.List;

import com.springboot.jdbc.models.Cliente;

public interface ClienteDao {
	
	public List<Cliente> findAll();
	public int numClientes();

}
