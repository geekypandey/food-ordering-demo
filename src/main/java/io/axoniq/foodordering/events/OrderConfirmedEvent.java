package io.axoniq.foodordering.events;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderConfirmedEvent{
    private final UUID foodCartId;
}
