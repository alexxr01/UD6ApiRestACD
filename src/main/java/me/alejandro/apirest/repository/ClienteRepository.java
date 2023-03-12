package me.alejandro.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.alejandro.apirest.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
