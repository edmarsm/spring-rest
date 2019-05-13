package br.com.edmardesenv.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.edmardesenv.springrest.domain.Client;
import br.com.edmardesenv.springrest.exception.BusinessException;
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
	
	public Optional<Client> findByName(String name) {
		return repository.findByName(name);
	}
	
	public Client save(Client client) throws BusinessException {
		Optional<Client> byName = findByName(client.getName());
		if (byName.isPresent()) {
			throw new BusinessException("A client with same name already exists.");
		}
		return repository.save(client);
	}
	
	public Client update(Client client) throws BusinessException {
		Optional<Client> byId = findById(client.getId());
		if (!byId.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return repository.save(client);
	}
	
	public void delete(Integer clientId) {
		Optional<Client> byId = findById(clientId);
		if (byId.isPresent()) {
			repository.delete(byId.get());
		} else {
			throw new EmptyResultDataAccessException(1);
		}
	}
	
}
