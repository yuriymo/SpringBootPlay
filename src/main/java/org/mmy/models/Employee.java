package org.mmy.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString(includeFieldNames = false, of = {"id", "firstName", "lastName"})
public class Employee {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String email;
}
