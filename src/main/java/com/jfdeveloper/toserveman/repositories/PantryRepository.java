package com.jfdeveloper.toserveman.repositories;

import com.jfdeveloper.toserveman.entities.Pantry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PantryRepository extends JpaRepository<Pantry, Long> {
}
