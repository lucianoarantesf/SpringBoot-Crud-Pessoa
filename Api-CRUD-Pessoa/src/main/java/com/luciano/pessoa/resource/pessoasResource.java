package com.luciano.pessoa.resource;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luciano.pessoa.domain.pessoas;
import com.luciano.pessoa.services.servicespessoas;

@RestController
@RequestMapping(value="pessoas")
public class pessoasResource {
	
	
	@Autowired
	private servicespessoas service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<pessoas> buscar(@PathVariable Integer id){
		pessoas p = service.buscar(id);
		
		return ResponseEntity.ok().body(p);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<pessoas>> findAll(){
		List<pessoas> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody pessoas p){
		p = service.insert(p);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(p.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody pessoas p, @PathVariable Integer id){
		p.setId(id);
		p = service.update(p);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}


