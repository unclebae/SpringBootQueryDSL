package com.eunkong.querydsl.customer.dto;

import com.eunkong.querydsl.customer.entity.Customer;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    public static Customer requestToEntity(CustomerRequest request) {
        if (request == null) return null;

        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        return customer;
    }

    public static CustomerResponse entityToResponse(Customer customer) {
        if (customer == null) return null;

        CustomerResponse response = new CustomerResponse();
        response.setId(customer.getId());
        response.setFirstName(customer.getFirstName());
        response.setLastName(customer.getLastName());

        return response;
    }

    public static List<CustomerResponse> entitiesToResponses(Page<Customer> customers) {
        if (customers == null || customers.getContent() == null) return List.of();

        return customers.getContent().stream().map(CustomerMapper::entityToResponse).collect(Collectors.toList());
    }
}
