package com.reservas.categorydish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryCategoryDish extends JpaRepository<CategoryDish, Long> {

    Optional<CategoryDish> findByName(String name);
}
