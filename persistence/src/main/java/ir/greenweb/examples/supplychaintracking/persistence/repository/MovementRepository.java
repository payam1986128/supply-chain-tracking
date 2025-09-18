package ir.greenweb.examples.supplychaintracking.persistence.repository;

import ir.greenweb.examples.supplychaintracking.persistence.entity.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MovementRepository extends JpaRepository<Movement, UUID> {
}
