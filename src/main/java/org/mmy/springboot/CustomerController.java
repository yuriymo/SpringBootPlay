package org.mmy.springboot;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers-all")
    public List<Customer> getCustomers() {
        return Lists.newArrayList(customerRepository.findAll());
    }

    @GetMapping("/customers-by")
    public List<Customer> getCustomersByName(@Param("name") String name) {
        return Lists.newArrayList(customerRepository.findCustomersBy(name, Sort.by("lastName")));
    }
}
