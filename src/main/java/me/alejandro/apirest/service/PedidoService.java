package me.alejandro.apirest.service;

import java.util.Optional;

import me.alejandro.apirest.entity.Pedido;

public interface PedidoService {
	
	public Iterable<Pedido> findAll();
	
	public Optional<Pedido> findById(Integer id);
	
	public Pedido save(Pedido pedido);
	
	public void deleteByiD(Integer id);
	
	
}


