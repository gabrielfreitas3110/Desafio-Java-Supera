package com.example.desafiojavasupera.services;

import com.example.desafiojavasupera.entities.Cart;
import com.example.desafiojavasupera.entities.Checkout;
import com.example.desafiojavasupera.entities.Client;
import com.example.desafiojavasupera.entities.enums.OrderStatus;
import com.example.desafiojavasupera.repositories.CartItemRepository;
import com.example.desafiojavasupera.repositories.CartRepository;
import com.example.desafiojavasupera.repositories.ClientRepository;
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
class CartServiceTest {

    @Autowired
    private CartService cartService;

    @MockBean
    private CartRepository cartRepository;

    @MockBean
    private CartItemRepository cartItemRepository;

    @MockBean
    private ClientRepository clientRepository;

    private Client cli1 = new Client(2L, null, null, null, null, null);
    private Cart c1 = new Cart(3L, cli1);

    @Test
    void ShouldFindAllCarts() {
        assertEquals(0  , cartRepository.findAll().size());
        when(cartRepository.findAll())
                .thenReturn((Stream.of(c1)).
                        collect(Collectors.toList()));
        assertEquals(1, cartRepository.findAll().size());
        assertEquals(3L, cartRepository.findAll().get(0).getId());
    }

    @Test
    void ShouldFindACartById() {
        Throwable exception = assertThrows(ObjectNotFoundException.class, () -> cartService.findById(10L));
        String eMessage = "Cart not found! Id: 10. Type: " + Cart.class.getName();
        when(cartRepository.findById(3L))
                .thenReturn(Optional.ofNullable(Stream.of(c1).
                        collect(Collectors.toList()).get(0)));
        assertTrue(cartRepository.findById(3L).isPresent());
        assertEquals(3, cartRepository.findById(3L).get().getId());
        assertThrows(ObjectNotFoundException.class, () -> cartService.findById(10L));
        assertEquals(eMessage, exception.getMessage());
    }

    @Test
    void ShouldAddAndRemoveProduct() {

    }

    @Test
    void insert() {
        when(cartRepository.save(c1))
                .thenReturn(Stream.of(c1)
                        .collect(Collectors.toList()).get(0));
        when(clientRepository.findById(2L))
                .thenReturn(Optional.ofNullable(Stream.of(cli1)
                        .collect(Collectors.toList()).get(0)));
        assertEquals(c1, cartRepository.save(c1));
        assertEquals(c1.getId(), cartRepository.save(c1).getId());
    }

    @Test
    void update() {
        c1.setCheckout(new Checkout(null, OrderStatus.DELIVERED, null));
        when(cartRepository.findById(3L))
                .thenReturn(Optional.ofNullable(Stream.of(c1)
                        .collect(Collectors.toList()).get(0)));
        when(cartService.update(3L, c1))
                .thenReturn(Stream.of(c1)
                        .collect(Collectors.toList()).get(0));

        assertEquals(OrderStatus.valueOf(4), cartService.update(3L, c1).getCheckout().getOrderStatus());
        assertEquals(c1, cartService.update(3L, c1));
    }
}