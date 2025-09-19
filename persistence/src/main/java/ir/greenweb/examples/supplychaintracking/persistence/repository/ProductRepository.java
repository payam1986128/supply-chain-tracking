package ir.greenweb.examples.supplychaintracking.persistence.repository;

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
public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query("from Product p " +
            "where (:t is null or p.type = :t) and " +
            "(:df is null or p.manufacturingDate > :df) and " +
            "(:dt is null or p.manufacturingDate < :dt) and " +
            "(:o is null or p.origin = :o)")
    Page<Product> filter(
            @Param("t") String type,
            @Param("df") LocalDateTime manufacturingDateFrom,
            @Param("dt") LocalDateTime manufacturingDateTo,
            @Param("o") String origin,
            Pageable pageable
    );
}
