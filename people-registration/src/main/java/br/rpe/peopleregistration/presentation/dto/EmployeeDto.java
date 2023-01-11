package br.rpe.peopleregistration.presentation.dto;

import java.util.Date;

import br.rpe.peopleregistration.model.entity.Address;
import br.rpe.peopleregistration.model.entity.Employee;
import br.rpe.peopleregistration.model.enums.Function;
import br.rpe.peopleregistration.model.enums.Status;

public class EmployeeDto {
	
	private Long id;
	private String cpf;
	private String name;
	private Address address;	
	private String telephone;
	private Function function;
	private Status status;
	private Date hiringDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Function getFunction() {
		return function;
	}
	public void setFunction(Function function) {
		this.function = function;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Date getHiringDate() {
		return hiringDate;
	}
	public void setHiringDate(Date hiringDate) {
		this.hiringDate = hiringDate;
	}
	
	

}
