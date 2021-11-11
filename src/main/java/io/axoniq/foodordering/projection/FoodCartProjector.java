package io.axoniq.foodordering.projection;

import io.axoniq.foodordering.queries.FindFoodCartQuery;
import io.axoniq.foodordering.events.FoodCartCreatedEvent;
import io.axoniq.foodordering.events.ProductDeselectedEvent;
import io.axoniq.foodordering.events.ProductSelectedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
class FoodCartProjector {

    private final FoodCartViewRepository foodCartViewRepository;

    public FoodCartProjector(FoodCartViewRepository foodCartViewRepository) {
        this.foodCartViewRepository = foodCartViewRepository;
    }

    @EventHandler
    public void on(FoodCartCreatedEvent event) {
        FoodCartView foodCartView = new FoodCartView(event.getFoodCardId(), Collections.emptyMap());
        foodCartViewRepository.save(foodCartView);
    }

    @EventHandler
    public void on(ProductSelectedEvent event) {
        foodCartViewRepository.findById(event.getFoodCartId()).ifPresent(
                foodCartView -> foodCartView.addProducts(event.getProductId(), event.getQuantity())
        );
    }

    @EventHandler
    public void on(ProductDeselectedEvent event) {
        foodCartViewRepository.findById(event.getFoodCartId()).ifPresent(
                foodCartView -> foodCartView.removeProducts(event.getProductId(), event.getQuantity())
        );
    }

    @QueryHandler
    public FoodCartView handle(FindFoodCartQuery query) {
        return foodCartViewRepository.findById(query.getFoodCardId()).orElse(null);
    }
}
