//package com.affiliate.app.routes;
//
//import com.affiliate.app.handler.Handler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.reactive.function.server.RequestPredicates;
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.RouterFunctions;
//import org.springframework.web.reactive.function.server.ServerResponse;
//
//
//@RestController
//public class UserRoutes {
//
//    @Autowired
//    private Handler handler;
//
//    @Bean
//    public RouterFunction<ServerResponse> route() {
//
//        return RouterFunctions
//                .route(RequestPredicates.GET("/api/welcome"), handler::sayWelcome)
//                .andRoute(RequestPredicates.POST("/auth/register"), handler::registerUser);
////                .andRoute(RequestPredicates.GET("/auth/generateToken"), handler::getToken);
//
//    }
//
//
//}
