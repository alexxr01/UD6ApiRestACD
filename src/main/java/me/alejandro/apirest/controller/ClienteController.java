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
import me.alejandro.apirest.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	public ClienteService clienteService;

	// Método para insertar valores
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Cliente cliente) {

		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
	}

	// Consulta por id
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Integer id) {

		Optional<Cliente> persona = clienteService.findById(id);

		if (!persona.isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(persona);
		}
	}

	// Método para actualizar
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Cliente cliente, @PathVariable(value = "id") Integer id) {

		Optional<Cliente> clienteModificar = clienteService.findById(id);

		if (!clienteModificar.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		// Actualizamos los valores
		clienteModificar.get().setId(cliente.getId());
		clienteModificar.get().setNombre(cliente.getNombre());
		clienteModificar.get().setApellido1(cliente.getApellido1());
		clienteModificar.get().setApellido2(cliente.getApellido2());

		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteModificar.get()));

	}

	// Borrar por id
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {

		Optional<Cliente> cliente = clienteService.findById(id);

		if (!cliente.isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			clienteService.deleteByiD(id);
			return ResponseEntity.ok().build();
		}
	}

	// Consulta por id
	@GetMapping
	public List<Cliente> readAll() {
		Iterable<Cliente> personasIterable = clienteService.findAll();
		List<Cliente> personas = StreamSupport.stream(personasIterable.spliterator(), false)
				.collect(Collectors.toList());

		return personas;

	}

}
