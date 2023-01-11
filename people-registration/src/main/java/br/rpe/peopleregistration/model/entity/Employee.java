package br.rpe.peopleregistration.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.rpe.peopleregistration.model.enums.Function;
import br.rpe.peopleregistration.model.enums.Status;

@Entity
@Table(name = "EMPLOYEE")
public class Employee extends Person{
	

	@Enumerated(EnumType.STRING)
	private Function function;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private Date hiringDate;

//	public Employee(Long id, String cpf, String name, Address address, String telephone, Function function,
//			Status status, Date hiringDate) {
//		super(id, cpf, name, address, telephone);
//		this.function = function;
//		this.status = status;
//		this.hiringDate = hiringDate;
//	}

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
