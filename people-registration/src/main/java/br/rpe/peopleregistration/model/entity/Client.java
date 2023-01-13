package br.rpe.peopleregistration.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

@Entity
@Table(name = "client")
public class Client extends Person {
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
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
