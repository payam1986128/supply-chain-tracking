package ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MovementCreationRequest {
    @Valid
    @NotNull
    private LocationDto sourceLocation;

    @Valid
    @NotNull
    private LocationDto destinationLocation;
}
