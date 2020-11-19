package org.mmy.dto;

import lombok.*;

@Getter
@Setter
@ToString(includeFieldNames = false)
@EqualsAndHashCode
public class CustomerDto {
    private String name;
    private String fname;
}
