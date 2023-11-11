package iuh.fit.week2.services;

import iuh.fit.week2.models.Order;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    boolean create(Order o);
    List<Order> findAll();
    List<Order> findOrdersByDate(LocalDate date);
    List<Order> findOrdersByDateRange(LocalDate s, LocalDate e);
    List<Order> findOrdersByEmployeeDateAndRange(LocalDate s, LocalDate e, String em);
}
