package com.affiliate.app.service;

import com.affiliate.app.entity.Items;
import com.affiliate.app.entity.ItemsUpdate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ItemService {

    Mono<Items> saveItem(Items item);

    Flux<Items> getItems();

    Mono<Items> updateItem(Long id, ItemsUpdate itemsMono);

    Mono<ServerResponse> deleteItem(Long id);

    Mono<Items> getItem(Long id);
}
