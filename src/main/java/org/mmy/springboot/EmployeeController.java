package org.mmy.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @RequestMapping("/employee")
    public List<Employee> getEmployees() {
        return List.of(
                new Employee(1, "lokesh", "gupta", "lokesh@c.cc"),
                new Employee(2, "ram", "gupta", "ram@c.cc"));
    }
}
