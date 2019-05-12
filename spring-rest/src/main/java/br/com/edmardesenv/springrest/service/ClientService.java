package br.com.edmardesenv.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.edmardesenv.springrest.domain.Client;
import br.com.edmardesenv.springrest.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public Optional<Client> findById(Integer id) {
		return repository.findById(id);
	}
	
	public List<Client> findAll() {
		return repository.findAll();
	}
	
	public Page<Client> findAll(PageRequest pageRequest) {
		return repository.findAll(pageRequest);
	}
	
	public List<Client> findByNameLike(String name) {
		return repository.findByNameLike(name);
	}
	
	public Client save(Client client) {
		return repository.save(client);
	}
	
}
