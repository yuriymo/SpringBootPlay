package org.mmy.persistence;

import org.mmy.models.Phone;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends PagingAndSortingRepository<Phone, Long> {
}
