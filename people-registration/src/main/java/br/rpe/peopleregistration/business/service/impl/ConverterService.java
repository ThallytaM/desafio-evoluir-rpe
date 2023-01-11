package br.rpe.peopleregistration.business.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.rpe.peopleregistration.model.entity.Client;
import br.rpe.peopleregistration.model.entity.Employee;
import br.rpe.peopleregistration.presentation.dto.ClientDto;
import br.rpe.peopleregistration.presentation.dto.EmployeeDto;

@Service
public class ConverterService {
	
	@Autowired
	private ModelMapper modelmapper;
	
	public Employee dtoToEmployee(EmployeeDto dto) {
		Employee entity = modelmapper.map(dto, Employee.class);
		return entity;
		
	}
	
	public EmployeeDto employeeToDto(Employee entity) {
		EmployeeDto dto = modelmapper.map(entity, EmployeeDto.class);
		return dto;
		
	}
	
	public Client dtoToClient(ClientDto dto) {
		Client entity = modelmapper.map(dto, Client.class);
		return entity;
	}
	
	public ClientDto clientToDto(Client entity) {
		ClientDto dto = modelmapper.map(entity, ClientDto.class);
		return dto;
	}
	
	
	

}
