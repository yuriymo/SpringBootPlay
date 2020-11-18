package org.mmy.springboot;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "phone", path = "phone")
public interface PhoneRepository extends PagingAndSortingRepository<Phone, Long> {
}
