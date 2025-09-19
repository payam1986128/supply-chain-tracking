package ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProductMovementsGetResponse {
    private List<ProductMovementDto> movements;
    private int total;
}
