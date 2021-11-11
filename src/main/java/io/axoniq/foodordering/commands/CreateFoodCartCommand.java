package io.axoniq.foodordering.commands;

import lombok.Data;
import org.axonframework.commandhandling.RoutingKey;

import java.util.UUID;

@Data
public class CreateFoodCartCommand {
    @RoutingKey
    private final UUID foodCartId;

    public CreateFoodCartCommand(UUID foodCartId) {
        this.foodCartId = foodCartId;
    }
}
