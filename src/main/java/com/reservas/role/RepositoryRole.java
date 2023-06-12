package com.reservas.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryRole extends JpaRepository<Roless, Long> {
    Optional<Roless> findByName(String roles);
}
