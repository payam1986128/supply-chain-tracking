package ir.greenweb.examples.supplychaintracking.contract.business;

import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement.MovementCreationRequest;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement.MovementCreationResponse;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement.ProductMovementsGetRequest;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.movement.ProductMovementsGetResponse;

public interface MovementServiceApi {
    MovementCreationResponse logMovement(String productId, MovementCreationRequest request);
    ProductMovementsGetResponse getMovements(String productId, ProductMovementsGetRequest request);
}
