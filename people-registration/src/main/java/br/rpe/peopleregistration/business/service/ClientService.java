package br.rpe.peopleregistration.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.rpe.peopleregistration.model.entity.Client;

@Service
public interface ClientService {
	
	public Client create(Client client);
	
	public Client update(Client client);
	
	public void delete(Long id);
	
	public Client findByName(String name);
	
	public Client findById(Long id);
	
	public Client findByCpf(String cpf);

}
