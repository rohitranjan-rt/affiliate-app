package com.affiliate.app.service;

import com.affiliate.app.entity.Items;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ItemService {

    public Mono<Items> saveItem(Items item) ;

    public Flux<Items> getItems() ;

    public Mono<ServerResponse> updateItem(ServerRequest request) ;

    public Mono<ServerResponse> deleteItem(Long id) ;

    public Mono<Items> getItem(Long id);
}
