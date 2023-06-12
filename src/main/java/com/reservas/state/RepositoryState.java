package com.reservas.state;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryState extends JpaRepository<States, Long> {

    Optional<States> findByName(String name);
}
