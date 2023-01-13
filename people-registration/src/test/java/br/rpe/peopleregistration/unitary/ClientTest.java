package br.rpe.peopleregistration.unitary;

import static org.junit.Assert.assertEquals;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.beans.factory.annotation.Autowired;

import br.rpe.peopleregistration.model.entity.Address;
import br.rpe.peopleregistration.model.entity.Client;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Testable
@DisplayName("Client")
class ClientTest {
	
	@Autowired
	private static Validator validator;
	
	@Autowired
	private static Client client;
	

	@BeforeAll
	static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    validator = factory.getValidator();
	    
	    client = new Client(1L, "", "Maria", new Address(), "(83) 22222-2222");
	}
	
	@Order(1)
	@ParameterizedTest
	@ValueSource(strings = {"Tha", "Jan4","Thallyta Maria Medeiros xxxxxxxxxxxxxxxxxxxxxxxxx5","Thallyta Maria Medeiros xxxxxxxxxxxxxxxxxxxxxxxx50", ""})
	void nameValidTest(String name) {
		client.setName(name);
		
		Set<ConstraintViolation<Client>> validacoes = validator.validateProperty(client, "name");		
		
		assertEquals(0, validacoes.size());
	}
	
	@Order(2)
	@ParameterizedTest
	@ValueSource(strings = {"085.228.024-67", "111.111.111-13","100.161.704-58"})
	void CpfValidTest(String cpf) {
		client.setCpf(cpf);
		
		Set<ConstraintViolation<Client>> validacoes = validator.validateProperty(client, "cpf");		
		
		assertEquals(0, validacoes.size());
	}
	
	
	

}
