package ir.greenweb.examples.supplychaintracking.persistence.repository;

import ir.greenweb.examples.supplychaintracking.persistence.entity.Movement;
import ir.greenweb.examples.supplychaintracking.persistence.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface MovementRepository extends JpaRepository<Movement, UUID>, QuerydslPredicateExecutor<Movement> { }
