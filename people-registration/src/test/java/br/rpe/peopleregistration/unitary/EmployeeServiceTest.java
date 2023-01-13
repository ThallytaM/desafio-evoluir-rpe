package br.rpe.peopleregistration.unitary;

import static org.junit.Assert.assertEquals;

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

import br.rpe.peopleregistration.business.service.EmployeeService;
import br.rpe.peopleregistration.model.entity.Address;
import br.rpe.peopleregistration.model.entity.Employee;
import br.rpe.peopleregistration.model.repository.EmployeeRepository;
import br.rpe.peopleregistration.presentation.dto.EmployeeDto;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
public class EmployeeServiceTest {
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	@Mock
	private EmployeeService employeeService;

	@Mock
	private List<Employee> EmployeeMock;
	
	@Mock
	private ModelMapper mapper;
	
	private Employee employee;
	
	private static EmployeeDto employeeDto;
	
	@BeforeAll
	static void before() {
		
	}
	void startClient() {
		employee = new Employee(1L, "111.111.111-11", "Maria", new Address(), "(83) 22222-2222");

	}
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		startClient();
	}
	
	@Order(1)
	@Test
	void testClientSave() throws Exception {		
		verifyNoInteractions(employeeService); //verifica chamadas se há outras além desta
		employeeService.create(employee);
		verify(employeeService, times(1)).create(employee);
	}
	
	@Order(2)	
	@Test
	void testUpdateName() {
		when(EmployeeMock.get(0)).thenReturn(new Employee(1L, "111.111.111-11", "Maria", new Address(), "(83) 22222-2222"));
		when(employeeService.update(any(Employee.class))).thenReturn(new Employee(1L, "111.111.111-11", "João", new Address(), "(83) 22222-2222"));
		
		String upName = "João";
		Employee employee = EmployeeMock.get(0);
		employee.setName(upName);
		
		Employee clientUp = employeeService.update(employee);
		
		assertEquals(upName, clientUp.getName());
	}
	
	@Order(3)	
	@Test
	void testDelete() {
		assertDoesNotThrow(()->  employeeService.delete(1L));
	}
}