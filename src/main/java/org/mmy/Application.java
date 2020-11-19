package org.mmy;

import lombok.extern.slf4j.Slf4j;
import org.mmy.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner initDB(CustomerService customerService) {
        return (args) -> customerService.fillCustomers();
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//            log.info("Beans provided by Spring Boot:");
//            Arrays.stream(ctx.getBeanDefinitionNames())
//                    .sorted()
//                    .forEach(log::info);
//        };
//    }
}