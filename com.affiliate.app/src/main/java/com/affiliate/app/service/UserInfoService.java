//package com.affiliate.app.service;
//
//import com.affiliate.app.entity.UserInfo;
//import com.affiliate.app.repository.UserInfoRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Mono;
//import org.springframework.security.core.GrantedAuthority;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Slf4j
//@Component
//public class UserInfoService implements UserDetailsService {
//
//    @Autowired
//    private UserInfoRepository repository;
//    @Autowired
//    private PasswordEncoder encoder;
//
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//        Optional<UserInfo> userInfo = repository.findByEmail(username);
//
//        if(userInfo.isEmpty()){
//            throw new UsernameNotFoundException("User name not found with email: " + username);
//        }
//
//        UserInfo user = userInfo.get();
//        Collection<? extends GrantedAuthority> authorities = List.of(user.getRoles().split(","))
//            .stream()
//            .map(role -> (GrantedAuthority) () -> role)
//            .collect(Collectors.toList());
//        return new User(user.getEmail(), user.getPassword(), authorities);
//    }
//
//    public Mono<String> saveUser(UserInfo userInfo){
//        log.info("Entered int the service: saveUser");
//        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
//        repository.save(userInfo);
//        return Mono.just("User added successfully");
//    }
//}
