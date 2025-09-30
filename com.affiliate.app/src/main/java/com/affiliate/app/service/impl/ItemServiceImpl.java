package com.affiliate.app.service.impl;

import com.affiliate.app.entity.Items;
import com.affiliate.app.entity.ItemsUpdate;
import com.affiliate.app.repository.ItemRepository;
import com.affiliate.app.service.ItemService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository repository;

    @Override
    public Mono<Items> saveItem(Items item) {
        log.info("Entered item service to save item.");
        return Mono.just(repository.save(item));
    }

    @Override
    public Flux<Items> getItems() {
        log.info("Entered item service to get items.");
        return Flux.fromIterable(repository.findAll());
    }

    @SneakyThrows
    @Override
    public Mono<Items> updateItem(Long id, ItemsUpdate newItemData) {
        log.info("Entered item service to update item.");

        return Mono.just(repository.findById(id)
                .map(existingItem -> {
                    // Update fields of the existing item
                    existingItem.setAffiliateUrl(newItemData.getAffiliateUrl());
                    existingItem.setImageUrl(newItemData.getImageUrl());
                    existingItem.setTitle(newItemData.getTitle());

                    return repository.save(existingItem);
                }).orElseThrow(Exception::new));
//                .onErrorResume(throwable -> );
//                .flatMap(updatedItem -> ServerResponse.ok().bodyValue(updatedItem))
//                .onErrorResume(e -> ServerResponse.badRequest().bodyValue(e.getMessage()));

//       return Mono.just(optionalItems.get());
//
//        return request.bodyToMono(Items.class)
//                .map(newItemData -> repository.findById(id)
//                        .map(existingItem -> {
//                            // Update fields of the existing item
//                            existingItem.setAffiliateUrl(newItemData.getAffiliateUrl());
//                            existingItem.setImageUrl(newItemData.getImageUrl());
//                            existingItem.setTitle(newItemData.getTitle());
//                            return repository.save(existingItem);
//                        }))
//                .switchIfEmpty(Mono.error(new RuntimeException("Item not found")))
//                .flatMap(updatedItem -> ServerResponse.ok().bodyValue(updatedItem))
//                .onErrorResume(e -> ServerResponse.badRequest().bodyValue(e.getMessage()));
    }

    @SneakyThrows
    @Override
    public Mono<ServerResponse> deleteItem(Long id) {
        log.info("Entered item service to delete item.");
        boolean exists = repository.existsById(id);
        if (exists) {
            repository.deleteById(id);
            return ServerResponse.ok().bodyValue("Item deleted.");
        } else {
            return ServerResponse.notFound().build().onErrorResume(e -> ServerResponse.badRequest().bodyValue(e.getMessage()));
        }
    }

    @SneakyThrows
    @Override
    public Mono<Items> getItem(Long id) {
        log.info("Entered item service to get item.");
        boolean exists = repository.existsById(id);
        if (exists) {
            return Mono.just(repository.findById(id).get());
        } else {
            return Mono.error(new RuntimeException("Item not found"));
        }
    }
}
