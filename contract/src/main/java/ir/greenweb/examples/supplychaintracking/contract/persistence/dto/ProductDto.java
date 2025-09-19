package ir.greenweb.examples.supplychaintracking.contract.persistence.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ProductDto {
    private UUID id;
    private String type;
    private LocalDateTime manufacturingDate;
    private String origin;
    private int version;
}
