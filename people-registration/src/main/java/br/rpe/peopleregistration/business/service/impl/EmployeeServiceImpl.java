package br.rpe.peopleregistration.business.service.impl;

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
		return employeeRepository.save(employee);
	}

	@Override
	public void delete(Long id) {
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
