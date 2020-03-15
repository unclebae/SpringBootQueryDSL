package com.eunkong.querydsl.customer.repository;

import com.eunkong.querydsl.customer.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerRepositoryCustom {

    Page<Customer> findAllByOrderFirstName(Pageable pageable);
}
