package ir.greenweb.examples.supplychaintracking.business.service;

import ir.greenweb.examples.supplychaintracking.business.exception.InvalidUUIDException;
import ir.greenweb.examples.supplychaintracking.business.exception.ProductNotFoundException;
import ir.greenweb.examples.supplychaintracking.business.mapper.MovementMapper;
import ir.greenweb.examples.supplychaintracking.contract.business.MovementServiceApi;
import ir.greenweb.examples.supplychaintracking.contract.persistence.MovementDaoApi;
import ir.greenweb.examples.supplychaintracking.contract.persistence.ProductDaoApi;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.MovementDto;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.MovementFilterDto;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.MovementsDto;
import ir.greenweb.examples.supplychaintracking.contract.persistence.dto.ProductDto;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement.MovementCreationRequest;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement.MovementCreationResponse;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement.ProductMovementsGetRequest;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement.ProductMovementsGetResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MovementService implements MovementServiceApi {

    private final MovementDaoApi movementDao;
    private final ProductDaoApi productDao;
    private final MovementMapper movementMapper;

    @Override
    public MovementCreationResponse logMovement(String productIdString, MovementCreationRequest request) {
        LocalDateTime submitTime = LocalDateTime.now();
        UUID productId = parseId(productIdString);
        validateProductExistence(productId);
        MovementDto movement = movementMapper.toMovementDto(request);
        movement.setProductId(productId);
        movement.setTime(submitTime);
        UUID savedId = movementDao.create(movement);
        return MovementCreationResponse.builder()
                .id(movementMapper.toString(savedId))
                .time(submitTime)
                .build();
    }

    @Override
    public ProductMovementsGetResponse getMovements(String productIdString, ProductMovementsGetRequest request) {
        UUID productId = parseId(productIdString);
        MovementFilterDto filter = movementMapper.toMovementFilterDto(request);
        filter.setProductId(productId);
        MovementsDto movementsDto = movementDao.filter(filter);
        return movementMapper.toProductMovementsGetResponse(movementsDto);
    }

    private UUID parseId(String id) {
        try {
            return UUID.fromString(id);
        } catch (Exception e) {
            throw new InvalidUUIDException();
        }
    }

    private void validateProductExistence(UUID id) {
        boolean existence = productDao.isProductExist(id);
        if (!existence) {
            throw new ProductNotFoundException();
        }
    }
}
