package br.rpe.peopleregistration.presentation.control;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.rpe.peopleregistration.model.entity.Client;
import br.rpe.peopleregistration.presentation.dto.ClientDto;

@Testable
public class ClientControllerTest {
	
	@Autowired
	private ClientController clientController;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	protected void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
	}
	
	@Test
	public void returnCreatedClient() throws  Exception {
		ClientDto clienteDTO = new ClientDto();
		clienteDTO.setName("teste");
		
		ResponseEntity<String> response = clientController.create(clienteDTO);
		System.out.println(response);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());	
		
	}

}
