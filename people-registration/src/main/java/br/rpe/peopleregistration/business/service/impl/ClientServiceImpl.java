package br.rpe.peopleregistration.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.rpe.peopleregistration.business.service.ClientService;
import br.rpe.peopleregistration.model.entity.Client;
import br.rpe.peopleregistration.model.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client save(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client update(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public void delete(Long id) {
		clientRepository.deleteById(id);;
	}

	@Override
	public Client findByName(String name) {
		return null;
	}

	@Override
	public Client findById(Long id) {
		return clientRepository.findById(id).get();
	}
	
	

}
