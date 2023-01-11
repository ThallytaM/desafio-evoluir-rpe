package br.rpe.peopleregistration.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;

import br.rpe.peopleregistration.business.service.ClientService;
import br.rpe.peopleregistration.model.entity.Client;
import br.rpe.peopleregistration.model.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client create(Client client) {
		if((findByCpf(client.getCpf()) != null)){
			throw new IllegalStateException("Cliente ja cadastrado!");
		}
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

	@Override
	public Client findByCpf(String cpf) {
		if(cpf == null) {
			throw new IllegalStateException("CPF cannot be null");
		}
		Optional<Client> optional = clientRepository.findByCpf(cpf);
		return optional.isPresent() ? optional.get() : null;
	}
}
