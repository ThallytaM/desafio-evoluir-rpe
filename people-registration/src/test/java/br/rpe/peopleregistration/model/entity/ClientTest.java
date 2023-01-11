package br.rpe.peopleregistration.model.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.beans.factory.annotation.Autowired;

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
	    
	    client = new Client();
		client.setCpf("111.111.111-11");
		client.setId(1L);
		client.setAddress(new Address());
		client.setTelephone("(11) 11111-1111");
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Tha", "Jan4","Thallyta Maria Medeiros xxxxxxxxxxxxxxxxxxxxxxxxx51","Thallyta Maria Medeiros xxxxxxxxxxxxxxxxxxxxxxxx50", ""})
	void nameTest(String name) {
		client.setName(name);
		
		Set<ConstraintViolation<Client>> validacoes = validator.validateProperty(client, "name");		
		
		assertEquals(0, validacoes.size());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"111.111.111-11", "11111111111",""})
	void CpfTest(String cpf) {
		client.setName(cpf);
		
		Set<ConstraintViolation<Client>> validacoes = validator.validateProperty(client, "cpf");		
		
		assertEquals(0, validacoes.size());
	}
	
	
	

}
