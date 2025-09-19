package ir.greenweb.examples.supplychaintracking.persistence.dao;

import ir.greenweb.examples.supplychaintracking.contract.persistence.MovementDaoApi;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.MovementDto;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.MovementFilterDto;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.MovementsDto;
import ir.greenweb.examples.supplychaintracking.persistence.entity.Movement;
import ir.greenweb.examples.supplychaintracking.persistence.mapper.MovementMapper;
import ir.greenweb.examples.supplychaintracking.persistence.repository.MovementRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class MovementDao implements MovementDaoApi {

    private final MovementRepository movementRepository;
    private final MovementMapper movementMapper;

    @Override
    public UUID create(MovementDto movementDto) {
        Movement movement = movementMapper.toMovement(movementDto);
        movementRepository.save(movement);
        return movement.getId();
    }

    @Override
    public MovementsDto filter(MovementFilterDto filter) {
        Page<Movement> movementsPage = movementRepository.filter(filter.getProductId(), filter.getTimeFrom(), filter.getTimeTo(),
                PageRequest.of(filter.getPage(), filter.getPageSize(), Sort.by(Sort.Direction.valueOf(filter.getSortDirection()), filter.getSort())));
        return MovementsDto.builder()
                .movements(movementMapper.toMovementsDto(movementsPage.getContent()))
                .total(movementsPage.getSize())
                .build();
    }
}
