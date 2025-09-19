package ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement;

import ir.greenweb.examples.supplychaintracking.contract.enumeration.SortDirection;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductMovementsGetRequest {
    @Min(1)
    private int page = 1;
    @Min(1)
    private int pageSize = 10;
    private String sort;
    private SortDirection sortDirection = SortDirection.ASC;
    private LocalDateTime timeFrom;
    private LocalDateTime timeTo;
}
