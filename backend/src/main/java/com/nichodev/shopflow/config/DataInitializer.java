package com.nichodev.shopflow.config;

import com.nichodev.shopflow.models.Role;
import com.nichodev.shopflow.models.User;
import com.nichodev.shopflow.repositories.RoleRepository;
import com.nichodev.shopflow.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(RoleRepository roleRepo, UserRepository userRepo, PasswordEncoder encoder) {


        return args -> {
            System.out.println("RUNNING DATA INITIALIZER...");

            if (!roleRepo.existsByName("ADMIN")) {
                roleRepo.save(new Role("ADMIN"));

            }

            // Create first admin user
            if (!userRepo.existsByEmail("nicholasfs40@gmail.com")) {

                User admin = new User();
                admin.setName("Nicholas Garcia");
                admin.setEmail("nicholasfs40@gmail.com");
                admin.setPassword(encoder.encode("123456"));
                Role adminRole = roleRepo.findByName("ADMIN").orElseThrow();
                admin.setRoles(Set.of(adminRole));
                userRepo.save(admin);
            }
        };
    }
}
