package ir.greenweb.examples.supplychaintracking.contract.presentation.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExceptionDto {
    private String code;
    private String description;
}
