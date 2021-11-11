package io.axoniq.foodordering.commands;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.util.UUID;

@Data
public class ConfirmOrderCommand {
        @TargetAggregateIdentifier
        private final UUID foodCartId;
}
