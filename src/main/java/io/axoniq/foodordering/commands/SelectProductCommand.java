package io.axoniq.foodordering.commands;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Data
public class SelectProductCommand {
    @TargetAggregateIdentifier
    private final UUID foodCartId;
    private final UUID productId;
    private final Integer quantity;
}
