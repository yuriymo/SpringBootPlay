package org.mmy.springboot;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "phone")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@ToString(includeFieldNames = false)
@EqualsAndHashCode
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "number")
    private String number;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
