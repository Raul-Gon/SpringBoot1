package com.miempresa.miprimercrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miempresa.miprimercrud.entity.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

}
