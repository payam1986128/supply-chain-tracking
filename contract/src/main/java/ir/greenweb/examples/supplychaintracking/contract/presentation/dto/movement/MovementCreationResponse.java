package ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class MovementCreationResponse {
    private String id;
    private LocalDateTime time;
}
