package com.example.desafiojavasupera.services;

import com.example.desafiojavasupera.entities.Checkout;
import com.example.desafiojavasupera.entities.enums.OrderStatus;
import com.example.desafiojavasupera.repositories.CheckoutRepository;
import com.example.desafiojavasupera.services.exception.ObjectNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CheckoutServiceTest {

    @Autowired
    private CheckoutService checkoutService;

    @MockBean
    private CheckoutRepository checkoutRepository;

    private Checkout ck1 = new Checkout(3L,null, null);
    @Test
    void findAll() {
       assertEquals(0  , checkoutRepository.findAll().size());
        when(checkoutRepository.findAll())
                .thenReturn((Stream.of(ck1)).
                        collect(Collectors.toList()));
        assertEquals(1, checkoutRepository.findAll().size());
        assertEquals(3L, checkoutRepository.findAll().get(0).getId());
    }

    @Test
    void findById() {
        Throwable exception = assertThrows(ObjectNotFoundException.class, () -> checkoutService.findById(10L));
        String eMessage = "Checkout not found! Id: 10. Type: " + Checkout.class.getName();
        when(checkoutRepository.findById(3L))
                .thenReturn(Optional.ofNullable(Stream.of(ck1).
                        collect(Collectors.toList()).get(0)));
        assertTrue(checkoutRepository.findById(3L).isPresent());
        assertEquals(3, checkoutRepository.findById(3L).get().getId());
        assertThrows(ObjectNotFoundException.class, () -> checkoutService.findById(10L));
        assertEquals(eMessage, exception.getMessage());
    }

    @Test
    void insert() {
        when(checkoutRepository.save(ck1))
            .thenReturn(Stream.of(ck1)
                    .collect(Collectors.toList()).get(0));
        assertEquals(ck1, checkoutRepository.save(ck1));
        assertEquals(ck1.getId(), checkoutRepository.save(ck1).getId());
    }

    @Test
    void update() {
        ck1.setOrderStatus(OrderStatus.DELIVERED);
        when(checkoutRepository.findById(3L))
                .thenReturn(Optional.ofNullable(Stream.of(ck1)
                        .collect(Collectors.toList()).get(0)));
        when(checkoutService.update(3L, ck1))
                .thenReturn(Stream.of(ck1)
                        .collect(Collectors.toList()).get(0));

        assertEquals(OrderStatus.valueOf(4), checkoutService.update(3L, ck1).getOrderStatus());
        assertEquals(ck1, checkoutService.update(3L, ck1));
    }
}