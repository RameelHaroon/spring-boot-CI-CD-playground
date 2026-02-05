package com.example.BasicCRUD.controller;

import com.example.BasicCRUD.model.CustomerDTO;
import com.example.BasicCRUD.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
@ActiveProfiles("test")
public class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockitoBean
    CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void test_listCustomers() throws Exception {
        CustomerDTO customer1 = CustomerDTO.builder().name("Customer 1").build();
        CustomerDTO customer2 = CustomerDTO.builder().name("Customer 2").build();
        List<CustomerDTO> dtos = new ArrayList<>();
        dtos.add(customer1);
        dtos.add(customer2);


        given(customerService.getAllCustomers()).willReturn(dtos);
        mockMvc.perform(get("/" + CustomerController.BASE_URL + CustomerController.V1_CUSTOMER).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.length()", is(2)));
    }
}
