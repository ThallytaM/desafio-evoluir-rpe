package br.rpe.peopleregistration.business.service.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;

import br.rpe.peopleregistration.business.service.EmployeeService;
import br.rpe.peopleregistration.model.entity.Client;
import br.rpe.peopleregistration.model.entity.Employee;
import br.rpe.peopleregistration.model.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee create (Employee employee) {
		if((findByCpf(employee.getCpf()) != null)){
			throw new IllegalStateException("Funcionario ja cadastrado!");
		}
		return employeeRepository.save(employee);
	}

	@Override
	public Employee update(Employee employee) {
		Employee employeeUp = findById(employee.getId());
		if(employeeUp == null) {
			throw new NoSuchElementException("Funcionário inexistente!");
		}
		employeeUp.getAddress().setCity(employee.getAddress().getCity());
		employeeUp.getAddress().setComplement(employee.getAddress().getComplement());
		employeeUp.getAddress().setCity(employee.getAddress().getCity());
		employeeUp.getAddress().setState(employee.getAddress().getState());
		employeeUp.getAddress().setZipCode(employee.getAddress().getZipCode());
		
		employeeUp.setCpf(employee.getCpf());
		employeeUp.setHiringDate(employee.getHiringDate());
		employeeUp.setName(employee.getName());
		employeeUp.setTelephone(employee.getTelephone());
		
		return employeeRepository.save(employeeUp);
	}

	@Override
	public void delete(Long id) {
		if(findById(id) == null) {
			throw new NoSuchElementException("Funcionário inexistente!");
		}
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee findByName(String name) {
		return null;
	}

	@Override
	public Employee findById(Long id) {
		return employeeRepository.findById(id).get();
	}
	
	@Override
	public Employee findByCpf(String cpf) {
		if(cpf == null) {
			throw new IllegalStateException("CPF cannot be null");
		}
		Optional<Employee> optional = employeeRepository.findByCpf(cpf);
		return optional.isPresent() ? optional.get() : null;
	}
	
	
}
