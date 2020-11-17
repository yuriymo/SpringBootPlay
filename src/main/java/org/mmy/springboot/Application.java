package org.mmy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
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