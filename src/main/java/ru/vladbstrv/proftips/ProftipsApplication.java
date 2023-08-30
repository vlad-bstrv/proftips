package ru.vladbstrv.proftips;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.vladbstrv.proftips.model.Post;
import ru.vladbstrv.proftips.model.User;
import ru.vladbstrv.proftips.repository.PostRepository;
import ru.vladbstrv.proftips.repository.UserRepository;

import java.time.LocalDateTime;

@SpringBootApplication
public class ProftipsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProftipsApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(UserRepository userRepository, PostRepository postRepository) {
//        return args -> {
//            User user = new User();
//            user.setFirstname("Vlad");
//            user.setLastname("Bystrov");
//            user.setEmail("keocer@gmail.com");
//            user.setPassword("password");
//            userRepository.save(user);
//        };
//    }

}
