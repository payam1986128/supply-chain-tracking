package ir.greenweb.examples.supplychaintracking.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "sct_product", indexes = {
        @Index(name = "productManufacturingDateIndex", columnList = "manufacturingDate DESC"),
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String type;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime manufacturingDate;
    private String origin;

    @Version
    private int version;
}
