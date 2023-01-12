package br.rpe.peopleregistration.business.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import br.rpe.peopleregistration.business.service.impl.ClientServiceImpl;
import br.rpe.peopleregistration.model.entity.Address;
import br.rpe.peopleregistration.model.entity.Client;
import br.rpe.peopleregistration.model.repository.ClientRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class ClientServiceTest {
	
	@Mock
	private ClientRepository clientRepository;
	
	@Mock
	private ClientService clientService;
	
	@Mock
	private ClientServiceImpl clientServiceImpl;
	
	@Mock
	private List<Client> clientsMock;
	
	@Mock
	private ModelMapper mapper;
	
	private static Client client;
	
	@BeforeAll
	static void before() {
		client = new Client(1L, "111.111.111-11", "Maria", new Address(), "(83) 22222-2222");
//		clientRepository =  mock(ClientRepository.class);
//		clientsMock =  mock(List.class);		
//		this.clientService = mock(ClientService.class);
//		this.clientServiceImpl = mock(ClientServiceImpl.class);
		
	}
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testSave() {		
		verifyNoInteractions(clientService); //verifica se há outras além das que chamei
		clientService.create(client);
		verify(clientService, times(1)).create(client);
	}
	
//	@Test
	void testClientCreate() {
	//	client.setCpf("333.333.333-33");
		
		when(clientRepository.save(client)).thenReturn(client);
		
		Client returnSave = clientService.create(client);
		
	//	assertNotNull(returnSave);
		
		assertEquals(Client.class, returnSave.getClass());
		
		assertEquals(client.getId(), returnSave.getId());
		assertEquals(client.getCpf(), returnSave.getCpf());
		assertEquals(client.getLastServiceDate(),returnSave.getLastServiceDate());
		assertEquals(client.getName(),returnSave.getName());
		assertEquals(client.getTelephone(), returnSave.getTelephone());
		
		//Verifica se o método foi chamado apenas uma vez
		verify(clientRepository, times(1)).save(returnSave);
		

	}
	
	@Test
	void testUpdate() {
		when(clientsMock.get(0)).thenReturn(new Client(1L, "111.111.111-11", "Maria", new Address(), "(83) 22222-2222"));
		when(clientService.update(any(Client.class))).thenReturn(new Client(1L, "111.111.111-11", "João", new Address(), "(83) 22222-2222"));
		
		String upName = "João";
		Client client = clientsMock.get(0);
		client.setName(upName);
		
		Client clientUp = clientService.update(client);
		
		assertEquals(upName, clientUp.getName());
	}
	
	@Test
	void testDelete() {
		assertThrows(IllegalStateException.class, () -> clientService.delete(null));
	}
}