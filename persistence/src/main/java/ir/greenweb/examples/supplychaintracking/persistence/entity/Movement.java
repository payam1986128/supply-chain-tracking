package ir.greenweb.examples.supplychaintracking.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "sct_movement")
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "source_location_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "source_location_longitude")),
    })
    private Location sourceLocation;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "destination_location_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "destination_location_longitude")),
    })
    private Location destinationLocation;

    private LocalDateTime time;
}
