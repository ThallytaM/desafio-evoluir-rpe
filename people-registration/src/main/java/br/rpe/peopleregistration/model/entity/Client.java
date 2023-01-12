package br.rpe.peopleregistration.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "client")
public class Client extends Person {
	
	private Date lastServiceDate;
	
	public Client() {
	}

	public Client(Long id, String cpf, @Size(min = 4, max = 50) String name, Address address, String telephone) {
		super(id, cpf, name, address, telephone);
	}

	public Date getLastServiceDate() {
		return lastServiceDate;
	}

	public void setLastServiceDate(Date lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}
	
	
	
	

}
