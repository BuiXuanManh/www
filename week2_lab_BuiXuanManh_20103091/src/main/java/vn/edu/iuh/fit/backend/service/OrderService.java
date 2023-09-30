package vn.edu.iuh.fit.backend.service;

import vn.edu.iuh.fit.backend.models.Order;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    boolean create(Order o);
    List<Order> findAll();
    List<Order> findOrdersByDate(LocalDate date);
    List<Order> findOrdersByDateRange(LocalDate s, LocalDate e);
    List<Order> findOrdersByEmployeeDateAndRange(LocalDate s, LocalDate e, String em);

    Order findById(Long id);
    boolean update(Order order);
}
