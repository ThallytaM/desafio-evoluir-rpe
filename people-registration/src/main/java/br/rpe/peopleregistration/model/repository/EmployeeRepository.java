package br.rpe.peopleregistration.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.common.base.Optional;

import br.rpe.peopleregistration.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	Optional<Employee>findByCpf(String cpf);

}
