package iuh.fit.week2.services;

import iuh.fit.week2.models.Order;

import java.util.List;

public interface OrderService {
    boolean create(Order o);
    List<Order> findAll();
}
