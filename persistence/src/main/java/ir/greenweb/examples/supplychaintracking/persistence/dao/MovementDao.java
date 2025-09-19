package ir.greenweb.examples.supplychaintracking.persistence.dao;

import com.querydsl.core.types.dsl.BooleanExpression;
import ir.greenweb.examples.supplychaintracking.contract.persistence.MovementDaoApi;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.MovementDto;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.MovementFilterDto;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.MovementsDto;
import ir.greenweb.examples.supplychaintracking.persistence.entity.Movement;
import ir.greenweb.examples.supplychaintracking.persistence.entity.QMovement;
import ir.greenweb.examples.supplychaintracking.persistence.mapper.MovementPersistenceMapper;
import ir.greenweb.examples.supplychaintracking.persistence.repository.MovementRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@AllArgsConstructor
public class MovementDao implements MovementDaoApi {

    private final MovementRepository movementRepository;
    private final MovementPersistenceMapper movementMapper;

    @Override
    public UUID create(MovementDto movementDto) {
        Movement movement = movementMapper.toMovement(movementDto);
        movementRepository.save(movement);
        return movement.getId();
    }

    @Override
    public MovementsDto filter(MovementFilterDto filter) {
        PageRequest pageRequest = PageRequest.of(filter.getPage()-1, filter.getPageSize());
        if (filter.getSort() != null && filter.getSortDirection() != null) {
            pageRequest.withSort(Sort.Direction.valueOf(filter.getSortDirection().name()), filter.getSort());
        }
        BooleanExpression predicate = QMovement.movement.time.before(LocalDateTime.now());
        if (filter.getProductId() != null) {
            predicate = predicate.and(QMovement.movement.product.id.eq(filter.getProductId()));
        }
        if (filter.getTimeFrom() != null) {
            predicate = predicate.and(QMovement.movement.time.after(filter.getTimeFrom()));
        }
        if (filter.getTimeTo() != null) {
            predicate = predicate.and(QMovement.movement.time.before(filter.getTimeTo()));
        }
        Page<Movement> movementsPage = movementRepository.findAll(predicate, pageRequest);
        return MovementsDto.builder()
                .movements(movementMapper.toMovementsDto(movementsPage.getContent()))
                .total(movementsPage.getTotalElements())
                .build();
    }
}
