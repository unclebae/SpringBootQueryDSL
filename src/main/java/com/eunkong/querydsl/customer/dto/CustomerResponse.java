package com.eunkong.querydsl.customer.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class CustomerResponse {
    private Long id;
    private String firstName;
    private String lastName;
}
