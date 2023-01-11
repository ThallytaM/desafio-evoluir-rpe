package br.rpe.peopleregistration.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.rpe.peopleregistration.model.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
