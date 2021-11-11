package io.axoniq.foodordering.events;

import lombok.Data;

import java.util.UUID;

@Data
public class FoodCartCreatedEvent {
    private final UUID foodCardId;
}
