package br.rpe.peopleregistration.business.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

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
		Client clientUp = findById(client.getId());
		if(clientUp == null ) {
			throw new NoSuchElementException("Cliente inexistente!");
		}
		clientUp.getAddress().setCity(client.getAddress().getCity());
		clientUp.getAddress().setComplement(client.getAddress().getComplement());
		clientUp.getAddress().setCity(client.getAddress().getCity());
		clientUp.getAddress().setState(client.getAddress().getState());
		clientUp.getAddress().setZipCode(client.getAddress().getZipCode());
		
		clientUp.setCpf(client.getCpf());
		clientUp.setLastServiceDate(client.getLastServiceDate());
		clientUp.setName(client.getName());
		clientUp.setTelephone(client.getTelephone());
		
		return clientRepository.save(clientUp);
	}

	@Override
	public void delete(Long id) {
	//	Client client = findById(id);
		if(findById(id) == null) {
			throw new NoSuchElementException("Cliente inexistente!");
		}
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
