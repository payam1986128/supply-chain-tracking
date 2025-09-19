package ir.greenweb.examples.supplychaintracking.contract.presentation.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductCreationRequest {
    @NotBlank
    private String type;

    @NotNull
    private LocalDateTime manufacturingDate;

    private String origin;
}
