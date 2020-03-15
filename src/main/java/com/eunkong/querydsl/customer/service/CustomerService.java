package com.eunkong.querydsl.customer.service;

import com.eunkong.querydsl.customer.entity.Customer;
import com.eunkong.querydsl.customer.dto.CustomerMapper;
import com.eunkong.querydsl.customer.dto.CustomerRequest;
import com.eunkong.querydsl.customer.dto.CustomerResponse;
import com.eunkong.querydsl.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponse save(CustomerRequest request) {
        Customer customer = CustomerMapper.requestToEntity(request);

        Customer save = customerRepository.save(customer);

        return CustomerMapper.entityToResponse(save);
    }

    public Page<CustomerResponse> findAll(Pageable pageable) {

        Page<Customer> customers = customerRepository.findAll(pageable);

        return new PageImpl<>(CustomerMapper.entitiesToResponses(customers), customers.getPageable(), customers.getTotalElements());
    }
}
