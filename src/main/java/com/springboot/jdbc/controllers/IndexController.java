package com.springboot.jdbc.controllers;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.jdbc.dao.ClienteDao;
import com.springboot.jdbc.models.Cliente;


@Controller
public class IndexController {
	
	@Autowired
	private  ClienteDao clienteDao;

	@GetMapping("/clientes")
	public void clientes() {
		System.out.println("Número de clientes: " + this.clienteDao.numClientes());
		System.out.println("Lista de Clientes:");
		List<Cliente> clientes = this.clienteDao.findAll();
		
		Iterator<Cliente> it = clientes.iterator();
		while (it.hasNext()) {
			Cliente cliente = (Cliente)it.next();
			System.out.println(cliente.toString());
		}
		
	}
}
