package org.mmy.springboot;

import com.google.common.collect.Streams;
import lombok.extern.slf4j.Slf4j;
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
    public CommandLineRunner initDB(CustomerRepository customerRepository, PhoneRepository phoneRepository) {
        return (args) -> {
            phoneRepository.save(new Phone("+380500000001"));
            phoneRepository.save(new Phone("+380500000002"));
            phoneRepository.save(new Phone("+380500000003"));
            phoneRepository.save(new Phone("+380500000004"));
            phoneRepository.save(new Phone("+380500000005"));
            phoneRepository.save(new Phone("+380500000006"));
            phoneRepository.save(new Phone("+380500000007"));
            // save a few customers
//            customerRepository.save(new Customer("Jack", "Bauer", List.of(phoneRepository.findById(1L).get())));
//            customerRepository.save(new Customer("Chloe", "O'Brian", List.of(phoneRepository.findById(2L).get())));
//            customerRepository.save(new Customer("Kim", "Bauer", List.of(phoneRepository.findById(3L).get())));
//            customerRepository.save(new Customer("David", "Palmer", List.of(phoneRepository.findById(4L).get())));
//            customerRepository.save(new Customer("Michelle", "Dessler", List.of(phoneRepository.findById(5L).get())));
//            customerRepository.save(new Customer("Serg", "Plotkin", List.of(phoneRepository.findById(6L).get())));
            customerRepository.save(new Customer("Jack", "Bauer"));
            customerRepository.save(new Customer("Chloe", "O'Brian"));
            customerRepository.save(new Customer("Kim", "Bauer"));
            customerRepository.save(new Customer("David", "Palmer"));
            customerRepository.save(new Customer("Michelle", "Dessler"));
            customerRepository.save(new Customer("Serg", "Plotkin"));

//            customerRepository.save(new Customer("Jack", "Bauer", List.of(new Phone("+380500000001"))));
//            customerRepository.save(new Customer("Chloe", "O'Brian", List.of(new Phone("+380500000002"))));
//            customerRepository.save(new Customer("Kim", "Bauer", List.of(new Phone("+380500000003"))));
//            customerRepository.save(new Customer("David", "Palmer", List.of(new Phone("+380500000004"))));
//            customerRepository.save(new Customer("Michelle", "Dessler", List.of(new Phone("+380500000005"))));
//            customerRepository.save(new Customer("Serg", "Plotkin", List.of(new Phone("+380500000006"))));
            // fetch all customers
            log.info("-------------------------------");
            Streams.stream(customerRepository.findAll())
                    .map(Object::toString)
                    .forEach(log::info);
            log.info("-------------------------------");
//            log.info("");
//            // fetch an individual customer by ID
//            Customer customer = customerRepository.findById(1L);
//            log.info("Customer found with findById(1L):");
//            log.info("--------------------------------");
//            log.info(customer.toString());
//            log.info("");
//
//            // fetch customers by last name
//            log.info("Customer found with findByLastName('Bauer'):");
//            log.info("--------------------------------------------");
//            customerRepository.findByLastName("Bauer").forEach(bauer -> {
//                log.info(bauer.toString());
//            });
//            // for (Customer bauer : customerRepository.findByLastName("Bauer")) {
//            //  log.info(bauer.toString());
//            // }
//            log.info("");
        };
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