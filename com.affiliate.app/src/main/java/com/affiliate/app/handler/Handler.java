//package com.affiliate.app.handler;
//
//import com.affiliate.app.entity.AuthRequest;
//import com.affiliate.app.entity.UserInfo;
////import com.affiliate.app.service.JwtService;
////import com.affiliate.app.service.UserInfoService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.server.ServerRequest;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import reactor.core.publisher.Mono;
//
//import java.util.concurrent.ExecutionException;
//
//@Slf4j
//@Component
//public class Handler {

//    @Autowired
//    UserInfoService userInfoService;
//    @Autowired
//    JwtService jwtService;
//    @Autowired
//    AuthenticationManager authenticationManager;



//    public Mono<ServerResponse> sayWelcome(ServerRequest request) {
//        log.info("Entered int the handler: sayWelcome");
//        return ServerResponse.ok().bodyValue("Welcome to Affiliate Application");
//    }
//
//    public Mono<ServerResponse> registerUser(ServerRequest request) {
//        log.info("Entered int the handler: registerUser");
//        return request.bodyToMono(UserInfo.class)
//                .flatMap(userInfoService::saveUser)
//                .flatMap(user -> ServerResponse.ok()
//                        .bodyValue("User Registered Successfully"));
//    }

//    public Mono<ServerResponse> getToken(ServerRequest request) {
//        log.info("Entered int the handler: getToken");
//        AuthRequest authRequest = null;
//        try {
//            authRequest = request.bodyToMono(AuthRequest.class).toFuture().get();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//        Authentication authentication = authenticationManager.authenticate(
//                new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
//                        authRequest.getUsername(), authRequest.getPassword()));
//        if (authentication.isAuthenticated()) {
//            return ServerResponse.ok().bodyValue(jwtService.generateToken(authRequest.getUsername()));
//        } else {
//            throw new UsernameNotFoundException("Invalid user request!!!");
//        }
//    }
//}
