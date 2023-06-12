package com.reservas.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryClient extends JpaRepository<Clientes, Long> {
    Optional<Clientes> findByEmail(String email);
}
