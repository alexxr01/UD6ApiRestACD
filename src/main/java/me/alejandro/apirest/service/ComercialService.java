package me.alejandro.apirest.service;

import java.util.Optional;

import me.alejandro.apirest.entity.Comercial;

public interface ComercialService {
	
	public Iterable<Comercial> findAll();
	
	public Optional<Comercial> findById(Integer id);
	
	public Comercial save(Comercial comercial);
	
	public void deleteByiD(Integer id);
	
	
}


