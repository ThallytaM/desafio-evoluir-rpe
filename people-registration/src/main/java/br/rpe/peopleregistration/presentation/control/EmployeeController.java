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

import br.rpe.peopleregistration.business.service.EmployeeService;
import br.rpe.peopleregistration.business.service.impl.ConverterService;
import br.rpe.peopleregistration.model.entity.Employee;
import br.rpe.peopleregistration.presentation.dto.EmployeeDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Funcionário")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ConverterService converterService;
	
	@ApiOperation(value = "Adicionar um Funcionário")
	@PostMapping
	public ResponseEntity create (@RequestBody EmployeeDto dto) {
		try {
			Employee entity = converterService.dtoToEmployee(dto);
			
			entity = employeeService.create(entity);
			dto = converterService.employeeToDto(entity);
			return new ResponseEntity(dto, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());		}			
	}
	
	@ApiOperation(value = "Alterar um Funcionário")
	@PutMapping({"{id}"})
	public ResponseEntity update(@PathVariable Long id, @RequestBody EmployeeDto dto) {
		try {
			dto.setId(id);
			
			Long employeeId = dto.getId();
			Employee employee = employeeService.findById(employeeId);
			
			if(employee == null) {
				throw new IllegalStateException();
			}
			
			Employee entity = converterService.dtoToEmployee(dto);
			entity = employeeService.create(entity);
			dto = converterService.employeeToDto(entity);
			
			return ResponseEntity.ok(dto);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}	
	}
	@ApiOperation(value = "Remover um Funcionário")
	@DeleteMapping({"{id}"})
	public ResponseEntity delete(@PathVariable("id") Long id) {
		try {
			employeeService.delete(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());		
		}
	}
	
	@ApiOperation(value = "Consultar um Funcionário")
	@GetMapping("{id}")
	public ResponseEntity findById(@PathVariable("id")Long id) {
		
		try {
			Employee entity = employeeService.findById(id);
			
			EmployeeDto dto = converterService.employeeToDto(entity);
			
			return ResponseEntity.ok(dto);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}	
}
