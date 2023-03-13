package me.alejandro.apirest.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

import me.alejandro.apirest.entity.Cliente;
import me.alejandro.apirest.entity.Comercial;
import me.alejandro.apirest.service.ClienteService;
import me.alejandro.apirest.service.ComercialService;

@RestController
@RequestMapping("/comercial")
public class ComercialController {

	@Autowired
	public ComercialService comercialService;

	// Método para insertar valores
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Comercial comercial) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(comercialService.save(comercial));
	}

	// Consulta por id
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Integer id) {

		Optional<Comercial> comercial = comercialService.findById(id);

		if (!comercial.isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(comercial);
		}
	}

	// Método para actualizar
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Comercial comercial, @PathVariable(value = "id") Integer id) {

		Optional<Comercial> comercialModificar = comercialService.findById(id);

		if (!comercialModificar.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		// Actualizamos los valores
		comercialModificar.get().setId(comercial.getId());
		comercialModificar.get().setNombre(comercial.getNombre());
		comercialModificar.get().setApellido1(comercial.getApellido1());
		comercialModificar.get().setApellido2(comercial.getApellido2());

		return ResponseEntity.status(HttpStatus.CREATED).body(comercialService.save(comercialModificar.get()));

	}

	// Borrar por id
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {

		Optional<Comercial> comercial = comercialService.findById(id);

		if (!comercial.isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			comercialService.deleteByiD(id);
			return ResponseEntity.ok().build();
		}
	}

	// Consulta por id
	@GetMapping
	public List<Comercial> readAll() {
		Iterable<Comercial> comercialesIterable = comercialService.findAll();
		List<Comercial> comerciales = StreamSupport.stream(comercialesIterable.spliterator(), false)
				.collect(Collectors.toList());

		return comerciales;

	}

}
