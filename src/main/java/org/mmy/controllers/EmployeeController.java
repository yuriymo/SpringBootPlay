package org.mmy.controllers;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.mmy.models.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@RestController
public class EmployeeController {

    public static final List<Employee> EMPLOYEES = List.of(
            new Employee(1, "lokesh", "gupta", "lokesh@c.cc"),
            new Employee(2, "ram", "gupta", "ram@c.cc"),
            new Employee(3, "sergey", "plotkin", "serg@c.cc"));

    @GetMapping("/employees-all")
    public List<Employee> getEmployees() {
        return EMPLOYEES;
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return EMPLOYEES.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/employee")
    public Employee getEmployeeById(@RequestParam("id") int id) {
        return EMPLOYEES.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployeeByName(@RequestParam("name") String name, @RequestParam(value = "distance", defaultValue = "1") int distance) {
        return EMPLOYEES.stream()
                .filter(employee -> isLike(name, employee, distance))
                .collect(toList());
    }

    private boolean isLike(String name, Employee employee, int distance) {
        LevenshteinDistance distanceMeter = LevenshteinDistance.getDefaultInstance();
        return Stream.of(
                employee.getFirstName(),
                employee.getLastName(),
                StringUtils.substringBefore(employee.getEmail(), "@"))
                .anyMatch(s -> distanceMeter.apply(s, name) <= distance);
    }
}
