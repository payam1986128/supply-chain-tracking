package ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDto {
    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;
}
