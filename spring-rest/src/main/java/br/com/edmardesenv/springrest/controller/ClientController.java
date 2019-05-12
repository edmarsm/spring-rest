package br.com.edmardesenv.springrest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edmardesenv.springrest.domain.Client;
import br.com.edmardesenv.springrest.dto.ClientDto;
import br.com.edmardesenv.springrest.service.ClientService;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*")
public class ClientController {
	
	@Autowired
	private ClientService service;
	
	@GetMapping("/{id}")
	public Optional<Client> findById(@PathVariable(name = "id") Integer id) {
		return service.findById(id);
	}
	
	@GetMapping()
	public List<Client> findAll() {
		return service.findAll();
	}
	
	@PostMapping
	public Client save(@Valid @RequestBody ClientDto client, BindingResult bindingResult) {
		return service.save(converterDtoParaEntidade(client));
	}

	private Client converterDtoParaEntidade(ClientDto client) {
		Client entity = new Client();
		entity.setId(client.getId());
		entity.setName(client.getName());
		return entity;
	}
	
	

}
