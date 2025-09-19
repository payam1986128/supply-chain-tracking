package ir.greenweb.examples.supplychaintracking.contract.persistence.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class MovementFilterDto {
    private int page;
    private int pageSize;
    private String sort;
    private String sortDirection;
    private UUID productId;
    private LocalDateTime timeFrom;
    private LocalDateTime timeTo;
}
