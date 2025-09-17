package ir.greenweb.examples.supplychaintracking.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
public class Product {
    @Id
    private UUID id;
    private String type;
    private LocalDateTime manufacturingDate;
    private String origin;
}
