package iocode.web.app.config;

import iocode.web.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public  UserDetailsService userDetailsService(){
        private final UserRepository userRepository;

    }
}
