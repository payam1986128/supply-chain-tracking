package ir.greenweb.examples.supplychaintracking.business.mapper;

import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.MovementDto;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.MovementFilterDto;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.MovementsDto;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement.MovementCreationRequest;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement.ProductMovementDto;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement.ProductMovementsGetRequest;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement.ProductMovementsGetResponse;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface MovementBusinessMapper {
    MovementDto toMovementDto(MovementCreationRequest movementCreationRequest);
    MovementFilterDto toMovementFilterDto(ProductMovementsGetRequest productMovementsGetRequest);
    ProductMovementsGetResponse toProductMovementsGetResponse(MovementsDto movementsDto);
    List<ProductMovementDto> toProductMovementsDto(List<MovementDto> movementsDto);
    ProductMovementDto toProductMovementDto(MovementDto movementDto);

    default String toString(UUID source) {
        return source.toString();
    }

    default UUID toUUID(String source) {
        return UUID.fromString(source);
    }
}
