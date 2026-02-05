package com.example.BasicCRUD.mapper;

import com.example.BasicCRUD.entity.Customer;
import com.example.BasicCRUD.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDTO dto);
    CustomerDTO customerToCustomerDto(Customer customer);
}
