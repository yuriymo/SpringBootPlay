package org.mmy.services;

import com.google.common.collect.Streams;
import lombok.extern.slf4j.Slf4j;
import org.mmy.dto.CustomerDto;
import org.mmy.models.Customer;
import org.mmy.persistence.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;

    public List<CustomerDto> getAll() {
        return Streams.stream(customerRepository.findAll())
                .map(customerMapper::toDto)
                .collect(toList());
    }

    public List<CustomerDto> getCustomersBy(String name, Sort sort) {
        return customerRepository.findCustomersBy(name, sort).stream()
                .map(customerMapper::toDto)
                .collect(toList());
    }

    public CustomerDto getCustomer(long id) {
        return customerRepository.findById(id)
                .map(customerMapper::toDto)
                .orElse(null);
    }

    public void fillCustomers() {
//        phoneRepository.save(new Phone("+380500000001"));
//        phoneRepository.save(new Phone("+380500000002"));
//        phoneRepository.save(new Phone("+380500000003"));
//        phoneRepository.save(new Phone("+380500000004"));
//        phoneRepository.save(new Phone("+380500000005"));
//        phoneRepository.save(new Phone("+380500000006"));
//        phoneRepository.save(new Phone("+380500000007"));
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
    }

    ;
}
