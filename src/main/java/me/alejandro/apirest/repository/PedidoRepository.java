package me.alejandro.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.alejandro.apirest.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
