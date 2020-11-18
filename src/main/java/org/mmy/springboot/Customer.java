package org.mmy.springboot;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@ToString(includeFieldNames = false)
@EqualsAndHashCode
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
}
