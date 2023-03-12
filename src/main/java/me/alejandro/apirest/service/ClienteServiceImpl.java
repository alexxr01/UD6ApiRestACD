package me.alejandro.apirest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.alejandro.apirest.entity.Cliente;
import me.alejandro.apirest.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Iterable<Cliente> findAll() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Override
	public Optional<Cliente> findById(Integer id) {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id);
	}

	@Override
	public Cliente save(Cliente persona) {
		// TODO Auto-generated method stub
		return clienteRepository.save(persona);
	}

	@Override
	public void deleteByiD(Integer id) {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(id);
		
	}

}
