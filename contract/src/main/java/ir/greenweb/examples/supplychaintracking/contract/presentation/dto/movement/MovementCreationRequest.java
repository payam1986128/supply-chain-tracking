package ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MovementCreationRequest {
    private LocationDto sourceLocation;
    private LocationDto destinationLocation;
}
