package ir.greenweb.examples.supplychaintracking.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class Movement {
    @Id
    private UUID id;

    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;

    private double latitude;
    private double longitude;
}
