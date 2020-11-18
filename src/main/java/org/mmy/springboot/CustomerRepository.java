package org.mmy.springboot;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    List<Customer> findByLastName(@Param("name") String name);

    @Query("select c " +
            "from Customer c " +
            "where lower(c.lastName) like lower(concat(:name, '%')) " +
            "or lower(c.firstName) like lower(concat(:name, '%')) ")
    List<Customer> findCustomersBy(@Param("name") String name, Sort sort);
}
