package org.mmy.controllers;

import org.mmy.dto.CustomerDto;
import org.mmy.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<CustomerDto> getCustomers() {
        return customerService.getAll();
    }

    @GetMapping("/customer/{id}")
    public CustomerDto getCustomer(@PathVariable long id) {
        return customerService.getCustomer(id);
    }

    @GetMapping("/customers-by")
    public List<CustomerDto> getCustomersByName(@Param("name") String name, @RequestParam(defaultValue = "lastName") String sortBy) {
        return customerService.getCustomersBy(name, sortBy);
    }
}
