package com.affiliate.app.handler;


import com.affiliate.app.entity.Items;
import com.affiliate.app.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class ItemHandler {

    @Autowired
    private ItemService itemService;

    public Mono<ServerResponse> addItem(ServerRequest request) {
        log.info("Entered item handler to add item");
        return request.bodyToMono(Items.class) // Extract the Item object from the request body
                .flatMap(itemService::saveItem) // Save the item using the service
                .flatMap(savedItem -> ServerResponse.ok().bodyValue(savedItem)) // Return the saved item in the response
                .onErrorResume(err -> ServerResponse.badRequest().bodyValue("Error: " + err.getMessage()));
    }

    public Mono<ServerResponse> getItems(ServerRequest request) {
        log.info("Entered item handler to get items.");
        Flux<Items> items = itemService.getItems(); // Fetch items reactively from the service
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(items, Items.class); // Return the Flux as the response body
    }

    public Mono<ServerResponse> updateItem(ServerRequest request) {
        log.info("Entered item handler to update item.");
        return ServerResponse.ok().bodyValue(itemService.updateItem(request));
    }

    public Mono<ServerResponse> deleteItem(ServerRequest request) {
        log.info("Entered item handler to delete item.");
        Long id = Long.valueOf(request.queryParam("id").get());
        return ServerResponse.ok().bodyValue(itemService.deleteItem(id));
    }

    public Mono<ServerResponse> getItem(ServerRequest request) {
        log.info("Entered item handler to get item.");
        Long id = Long.valueOf(request.queryParam("id").get());
        return ServerResponse.ok().bodyValue(itemService.getItem(id));
    }
}
