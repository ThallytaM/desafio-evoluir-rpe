package br.rpe.peopleregistration.business.service;

import org.springframework.stereotype.Service;

import br.rpe.peopleregistration.model.entity.Employee;

@Service
public interface EmployeeService {

	public Employee save(Employee client);
	
	public Employee update(Employee client);
	
	public void delete(Long id);
	
	public Employee findByName(String name);
	
	public Employee findById(Long id);
}
