package br.com.edmardesenv.springrest.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.edmardesenv.springrest.domain.Client;
import br.com.edmardesenv.springrest.repository.ClientRepository;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

	@InjectMocks
	private ClientService service;
	
	@Mock
	private ClientRepository repository;
	
	@Test
	public void mustReturnOneItemWhenCallingFindByIdToValidId() {
		// Scenario
		Client client = new Client();
		client.setId(1);
		client.setName("Test client");
		given(repository.findById(Mockito.anyInt())).willReturn(Optional.of(client));
		// Action
		Optional<Client> foundById = service.findById(1);
		
		// Verifying
		assertEquals(client, foundById.get());
		Mockito.verify(repository, Mockito.atLeastOnce()).findById(Mockito.anyInt());
	}
	
}
