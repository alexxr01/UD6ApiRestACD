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

import me.alejandro.apirest.entity.Pedido;
import me.alejandro.apirest.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	public PedidoService pedidoService;

	// Método para insertar valores
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Pedido pedido) {

		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(pedido));
	}

	// Consulta por id
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Integer id) {

		Optional<Pedido> pedido = pedidoService.findById(id);

		if (!pedido.isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(pedido);
		}
	}

	// Método para actualizar
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Pedido pedido, @PathVariable(value = "id") Integer id) {

		Optional<Pedido> pedidoModificar = pedidoService.findById(id);

		if (!pedidoModificar.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		// Actualizamos los valores
		pedidoModificar.get().setId(pedido.getId());
		pedidoModificar.get().setCantidad(pedido.getCantidad());
		pedidoModificar.get().setFecha(pedido.getFecha());
		pedidoModificar.get().setCliente(pedido.getCliente());
		pedidoModificar.get().setComercial(pedido.getComercial());

		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(pedidoModificar.get()));

	}

	// Borrar por id
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {

		Optional<Pedido> pedido = pedidoService.findById(id);

		if (!pedido.isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			pedidoService.deleteByiD(id);
			return ResponseEntity.ok().build();
		}
	}

	// Consulta por id
	@GetMapping
	public List<Pedido> readAll() {
		Iterable<Pedido> pedidoIterable = pedidoService.findAll();
		List<Pedido> personas = StreamSupport.stream(pedidoIterable.spliterator(), false)
				.collect(Collectors.toList());

		return personas;

	}

}
