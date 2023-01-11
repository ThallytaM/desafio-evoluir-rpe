package br.rpe.peopleregistration.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.common.base.Optional;

import br.rpe.peopleregistration.model.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	Optional<Client>findByCpf(String cpf);

}
