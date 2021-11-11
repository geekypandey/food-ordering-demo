package io.axoniq.foodordering.queries;

import lombok.Data;

import java.util.UUID;

@Data
public class FindFoodCartQuery {
    private final UUID foodCardId;
}

