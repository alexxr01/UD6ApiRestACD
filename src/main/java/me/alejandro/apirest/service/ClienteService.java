package me.alejandro.apirest.service;

import java.util.Optional;

import me.alejandro.apirest.entity.Cliente;

public interface ClienteService {
	
	public Iterable<Cliente> findAll();
	
	public Optional<Cliente> findById(Integer id);
	
	public Cliente save(Cliente cliente);
	
	public void deleteByiD(Integer id);
	
	
}


