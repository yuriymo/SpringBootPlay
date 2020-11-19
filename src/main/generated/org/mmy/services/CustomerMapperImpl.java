package org.mmy.services;

import javax.annotation.processing.Generated;
import org.mmy.dto.CustomerDto;
import org.mmy.models.Customer;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-19T23:09:48+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 15.0.1 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto toDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setName( customer.getFirstName() );
        customerDto.setFname( customer.getLastName() );

        return customerDto;
    }
}
