package com.morrisombiro.customer;

import org.springframework.stereotype.Service;

// bean to be injected into our controller
@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // todo: check if email is valid
        // todo: check if email is taken

        // save customer in db
        customerRepository.save(customer);
    }
}
