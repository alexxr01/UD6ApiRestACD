package me.alejandro.apirest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.alejandro.apirest.entity.Comercial;
import me.alejandro.apirest.repository.ComercialRepository;

@Service
public class ComercialServiceImpl implements ComercialService {
	
	
	@Autowired
	private ComercialRepository comercialRepository;

	@Override
	public Iterable<Comercial> findAll() {
		// TODO Auto-generated method stub
		return comercialRepository.findAll();
	}

	@Override
	public Optional<Comercial> findById(Integer id) {
		// TODO Auto-generated method stub
		return comercialRepository.findById(id);
	}

	@Override
	public Comercial save(Comercial comercial) {
		// TODO Auto-generated method stub
		return comercialRepository.save(comercial);
	}

	@Override
	public void deleteByiD(Integer id) {
		// TODO Auto-generated method stub
		comercialRepository.deleteById(id);
		
	}

}
