package br.rpe.peopleregistration.presentation.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.rpe.peopleregistration.business.service.ClientService;
import br.rpe.peopleregistration.business.service.impl.ConverterService;
import br.rpe.peopleregistration.model.entity.Client;
import br.rpe.peopleregistration.model.entity.Employee;
import br.rpe.peopleregistration.presentation.dto.ClientDto;
import br.rpe.peopleregistration.presentation.dto.EmployeeDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("/api/client")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ConverterService converterService;
	
	@ApiOperation(value = "Adicionar um Cliente")
	@PostMapping
	public ResponseEntity create (@RequestBody ClientDto dto) {
		try {
			Client entity = converterService.dtoToClient(dto);
			entity = clientService.create(entity);
			dto = converterService.clientToDto(entity);
			
			return new ResponseEntity(dto, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());		
		}			
	}
	
	@ApiOperation(value = "Alterar um Cliente")
	@PutMapping({"{id}"})
	public ResponseEntity update(@PathVariable Long id, @RequestBody ClientDto dto) {
		try {
			dto.setId(id);
			
			Long ClientId = dto.getId();
			Client client = clientService.findById(ClientId);
			
			if(client == null) {
				throw new IllegalStateException();
			}
			
			Client entity = converterService.dtoToClient(dto);
			entity = clientService.create(entity);
			dto = converterService.clientToDto(entity);
			
			return ResponseEntity.ok(dto);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}	
	}
	@ApiOperation(value = "Remover um Cliente")
	@DeleteMapping({"{id}"})
	public ResponseEntity delete(@PathVariable("id") Long id) {
		try {
			clientService.delete(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());		
		}
	}
	
	@ApiOperation(value = "Consultar um Cliente por ID")
	@GetMapping("{id}")
	public ResponseEntity findById(@PathVariable("id")Long id) {
		
		try {
			Client entity = clientService.findById(id);		
			ClientDto dto = converterService.clientToDto(entity);			
			return ResponseEntity.ok(dto);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}	
	
	@ApiOperation(value = "Consultar um Cliente por CPF")
	@GetMapping("findCpf/{cpf}")
	public ResponseEntity findByCpf(@PathVariable("cpf")String cpf) {
		
		try {
			Client entity = clientService.findByCpf(cpf);		
			ClientDto dto = converterService.clientToDto(entity);			
			return ResponseEntity.ok(dto);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
}

