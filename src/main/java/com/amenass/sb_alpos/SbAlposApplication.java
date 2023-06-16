package com.amenass.sb_alpos;

import com.amenass.sb_alpos.dto.auth.RegisterRequest;
import com.amenass.sb_alpos.security.auth.AuthService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.amenass.sb_alpos.security.Role.ADMIN;

@SpringBootApplication
public class SbAlposApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbAlposApplication.class, args);
    }




    @Bean
    public CommandLineRunner commandLineRunner(
            AuthService authService
    ) {
        return args -> {
            var admin = RegisterRequest.builder()
                    .firstname("Admin")
                    .lastname("Admin")
                    .email("admin@mail.com")
                    .password("12345678")
                    .role(ADMIN)
                    .build();
            System.out.println("Admin token: " + authService.register(admin).getAccessToken());
        };
    }

}
