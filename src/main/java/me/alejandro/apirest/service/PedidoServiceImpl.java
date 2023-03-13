package me.alejandro.apirest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.alejandro.apirest.entity.Pedido;
import me.alejandro.apirest.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public Iterable<Pedido> findAll() {
		// TODO Auto-generated method stub
		return pedidoRepository.findAll();
	}

	@Override
	public Optional<Pedido> findById(Integer id) {
		// TODO Auto-generated method stub
		return pedidoRepository.findById(id);
	}

	@Override
	public Pedido save(Pedido pedido) {
		// TODO Auto-generated method stub
		return pedidoRepository.save(pedido);
	}

	@Override
	public void deleteByiD(Integer id) {
		// TODO Auto-generated method stub
		pedidoRepository.deleteById(id);
		
	}

}
