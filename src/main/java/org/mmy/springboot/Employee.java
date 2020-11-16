package org.mmy.springboot;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Employee {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String email;
}
