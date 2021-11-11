package io.axoniq.foodordering.events;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductDeselectedEvent {
    private final UUID foodCartId;
    private final UUID productId;
    private final Integer quantity;
}
