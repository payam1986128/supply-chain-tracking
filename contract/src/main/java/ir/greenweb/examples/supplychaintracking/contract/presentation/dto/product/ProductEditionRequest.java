package ir.greenweb.examples.supplychaintracking.contract.presentation.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductEditionRequest {
    private String type;
    private LocalDateTime manufacturingDate;
    private String origin;
}
