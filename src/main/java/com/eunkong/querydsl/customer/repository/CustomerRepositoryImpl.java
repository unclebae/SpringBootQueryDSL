package com.eunkong.querydsl.customer.repository;

import com.eunkong.querydsl.customer.entity.Customer;
import com.eunkong.querydsl.customer.entity.QCustomer;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class CustomerRepositoryImpl extends QuerydslRepositorySupport implements CustomerRepositoryCustom {

    private QCustomer customer = QCustomer.customer;

    public CustomerRepositoryImpl() {
        super(QCustomer.class);
    }

    @Override
    public Page<Customer> findAllByOrderFirstName(Pageable pageable) {
        JPQLQuery<Customer> query = from(customer).orderBy(customer.firstName.desc());
        List<Customer> customers = getQuerydsl().applyPagination(pageable, query).fetch();

        return new PageImpl<>(customers, pageable, query.fetchCount());

    }
}
