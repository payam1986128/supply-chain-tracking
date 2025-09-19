package ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductMovementsGetRequest {
    private int page;
    private int pageSize;
    private String sort;
    private String sortDirection;
    private LocalDateTime timeFrom;
    private LocalDateTime timeTo;
}
