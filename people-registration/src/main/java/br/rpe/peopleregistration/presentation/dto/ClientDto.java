package br.rpe.peopleregistration.presentation.dto;

import java.util.Date;

import br.rpe.peopleregistration.model.entity.Address;
import br.rpe.peopleregistration.model.entity.Client;

public class ClientDto {
	
	private Long id;
	private String cpf;
	private String name;
	private Address address;	
	private String telephone;
	private Date lastServiceDate;
	
	public ClientDto(Client c) {
	}
	public ClientDto() {
		// TODO Auto-generated constructor stub
	}
	
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
	public Date getLastServiceDate() {
		return lastServiceDate;
	}
	public void setLastServiceDate(Date lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}

	
}
