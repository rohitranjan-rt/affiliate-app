package com.affiliate.app.routes;

import com.affiliate.app.handler.ItemHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
public class ItemRoutes {

//    @Autowired
//    private ItemHandler handler;

    @Bean
    public RouterFunction<ServerResponse> route(ItemHandler handler) {

        return RouterFunctions
                .route(RequestPredicates.POST("/api/addItem"), handler::addItem)
                .andRoute(RequestPredicates.GET("/api/getItems"), handler::getItems)
                .andRoute(RequestPredicates.PUT("/api/updateItem"), handler::updateItem)
                .andRoute(RequestPredicates.DELETE("/api/deleteItem"), handler::deleteItem)
                .andRoute(RequestPredicates.GET("/api/getItem"), handler::getItem);
//                .andRoute(RequestPredicates.GET("/auth/generateToken"), handler::getToken);

    }
}
