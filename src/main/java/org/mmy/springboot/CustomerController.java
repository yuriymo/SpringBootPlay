package org.mmy.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @GetMapping("/customers-all")
    public List<Customer> getCustomers() {
        return List.of(new Customer("serg", "plotkin"));
    }
}
