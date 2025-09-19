package ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductMovementDto {
    private String id;
    private String productId;
    private LocationDto sourceLocation;
    private LocationDto destinationLocation;
    private LocalDateTime time;
}
