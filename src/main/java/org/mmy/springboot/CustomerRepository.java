package org.mmy.springboot;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    List<Customer> findByLastName(@Param("name") String name);
}
