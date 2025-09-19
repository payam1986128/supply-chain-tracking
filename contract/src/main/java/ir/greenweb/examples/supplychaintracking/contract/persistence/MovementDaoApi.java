package ir.greenweb.examples.supplychaintracking.contract.persistence;

import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.MovementDto;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.MovementFilterDto;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.MovementsDto;

import java.util.UUID;

public interface MovementDaoApi {
    UUID create(MovementDto movement);
    MovementsDto filter(MovementFilterDto movementFilter);
}
