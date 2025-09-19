package ir.greenweb.examples.supplychaintracking.persistence.mapper;

import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.MovementDto;
import ir.greenweb.examples.supplychaintracking.persistence.entity.Movement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface MovementMapper {
    @Mapping(target = "product.id", source = "productId")
    Movement toMovement(MovementDto movementDto);

    @Mapping(target = "productId", source = "product.id")
    MovementDto toMovementDto(Movement movement);

    List<MovementDto> toMovementsDto(List<Movement> movements);
}
