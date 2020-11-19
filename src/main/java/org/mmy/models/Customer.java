package org.mmy.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@ToString(includeFieldNames = false)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "first_name")
    private String firstName;
    
    @NonNull
    @Column(name = "last_name")
    private String lastName;

//    @ManyToMany
//    @ToString.Exclude
//    @NonNull
//    @OneToMany (fetch = FetchType.EAGER, mappedBy = "customer")
//    private List<Phone> phones = new ArrayList<>();
}
