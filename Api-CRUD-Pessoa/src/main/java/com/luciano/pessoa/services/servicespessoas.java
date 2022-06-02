package com.luciano.pessoa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luciano.pessoa.domain.pessoas;
import com.luciano.pessoa.repository.pessoasRepository;

@Service
public class servicespessoas{

	@Autowired
	private pessoasRepository repository;
	
	public pessoas buscar(Integer id) {
		Optional<pessoas> p = repository.findById(id);
		return p.orElse(null);
	}
	
	public List<pessoas> findAll(){
		return repository.findAll();
	}
	
	public pessoas insert(pessoas p) {
		p.setId(null);
		return repository.save(p);
		
		
	}
	
	public pessoas update(pessoas p) {
		return repository.save(p);
	}
	
	public void delete(Integer id) {
		if(buscar(id) != null) {
			repository.deleteById(id);
		}
	}

}

