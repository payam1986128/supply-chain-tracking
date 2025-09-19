package ir.greenweb.examples.supplychaintracking.persistence.repository;

import ir.greenweb.examples.supplychaintracking.persistence.entity.Movement;
import ir.greenweb.examples.supplychaintracking.persistence.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface MovementRepository extends JpaRepository<Movement, UUID> {

    @Query("from Movement m " +
            "where (:pi is null or m.product.id = :pi) and " +
            "(:tf is null or m.time > :tf) and " +
            "(:tt is null or m.time < :tt)")
    Page<Movement> filter(
            @Param("pi") UUID productId,
            @Param("tf") LocalDateTime timeFrom,
            @Param("tt") LocalDateTime timeTo,
            Pageable pageable
    );
}
