package com.christhoper.curso.springboot.jpa.springboot_jpa_relationship.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.christhoper.curso.springboot.jpa.springboot_jpa_relationship.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
    @Query("SELECT c FROM Client c LEFT JOIN FETCH c.addresses WHERE c.id = ?1")
    Optional<Client> findOneWithAddresses(Long id);

    @Query("SELECT c FROM Client c LEFT JOIN FETCH c.invoices WHERE c.id = ?1")
    Optional<Client> findOneWithInvoices(Long id);
    
    @Query("SELECT c FROM Client c LEFT JOIN FETCH c.invoices LEFT JOIN FETCH c.addresses LEFT JOIN FETCH c.clientDetails WHERE c.id = ?1")
    Optional<Client> findOne(Long id);
}
