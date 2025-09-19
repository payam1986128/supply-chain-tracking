package ir.greenweb.examples.supplychaintracking.contract.persistence.dto;

import ir.greenweb.examples.supplychaintracking.contract.enumeration.SortDirection;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductFilterDto {
    private int page;
    private int pageSize;
    private String sort;
    private SortDirection sortDirection;
    private String type;
    private LocalDateTime manufacturingDateFrom;
    private LocalDateTime manufacturingDateTo;
    private String origin;
}
