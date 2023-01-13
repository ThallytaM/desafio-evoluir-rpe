package br.rpe.peopleregistration.unitary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import br.rpe.peopleregistration.business.service.ClientService;
import br.rpe.peopleregistration.model.entity.Address;
import br.rpe.peopleregistration.model.entity.Client;
import br.rpe.peopleregistration.model.repository.ClientRepository;
import br.rpe.peopleregistration.presentation.dto.ClientDto;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
public class ClientServiceTest {
	
	@Mock
	private ClientRepository clientRepository;
	
	@Mock
	private ClientService clientService;

	@Mock
	private List<Client> clientsMock;
	
	@Mock
	private ModelMapper mapper;
	
	private Client client;
	
	private static ClientDto clientDto;
	
	@BeforeAll
	static void before() {
		
	}
	void startClient() {
		client = new Client(1L, "111.111.111-11", "Maria", new Address(), "(83) 22222-2222");

	}
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		startClient();
	}
	
	@Order(1)
	@Test
	void testClientSave() throws Exception {		
		verifyNoInteractions(clientService); //verifica chamadas se há outras além desta
		clientService.create(client);
		verify(clientService, times(1)).create(client);
	}
	
	@Order(2)	
	@Test
	void testUpdateName() {
		when(clientsMock.get(0)).thenReturn(new Client(1L, "111.111.111-11", "Maria", new Address(), "(83) 22222-2222"));
		when(clientService.update(any(Client.class))).thenReturn(new Client(1L, "111.111.111-11", "João", new Address(), "(83) 22222-2222"));
		
		String upName = "João";
		Client client = clientsMock.get(0);
		client.setName(upName);
		
		Client clientUp = clientService.update(client);
		
		assertEquals(upName, clientUp.getName());
	}
	
	@Order(3)	
	@Test
	void testDelete() {
		assertDoesNotThrow(()->  clientService.delete(1L));
	}
}