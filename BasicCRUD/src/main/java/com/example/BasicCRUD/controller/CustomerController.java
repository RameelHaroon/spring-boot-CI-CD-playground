package com.example.BasicCRUD.controller;

import com.example.BasicCRUD.exception.NotFoundException;
import com.example.BasicCRUD.model.CustomerDTO;
import com.example.BasicCRUD.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "api/customerService";
    public static final String V1_CUSTOMER = "/v1/customer";
    public static final String V1_CUSTOMER_ID = V1_CUSTOMER + "/{customerId}";

    private final CustomerService customerService;

    @GetMapping(V1_CUSTOMER)
    public List<CustomerDTO> listAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(V1_CUSTOMER_ID)
    public CustomerDTO getCustomerById(@PathVariable("customerId") UUID customerId) {
        return customerService.getCustomerById(customerId).orElseThrow(NotFoundException::new);
    }

    @PostMapping(V1_CUSTOMER)
    public ResponseEntity createBeer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO savedBeer = customerService.saveNewCustomer(customerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", BASE_URL + V1_CUSTOMER + "/" + savedBeer.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
}
