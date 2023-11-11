package iuh.fit.week2.implement;

import iuh.fit.week2.models.Order;
import iuh.fit.week2.repositories.OrderRepository;
import iuh.fit.week2.services.OrderService;

import java.time.LocalDate;
import java.util.List;

public class OrderImplement implements OrderService {
    private OrderRepository repository;

    public OrderImplement() {
        repository= new OrderRepository();
    }

    @Override
    public boolean create(Order o) {
        return repository.create(o);
    }

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Order> findOrdersByDate(LocalDate date) {
        return repository.findOrdersByDate(date);
    }

    @Override
    public List<Order> findOrdersByDateRange(LocalDate s, LocalDate e) {
        return repository.findOrdersByDateRange(s,e);
    }

    @Override
    public List<Order> findOrdersByEmployeeDateAndRange(LocalDate s, LocalDate e, String em) {
        return repository.findOrdersByEmployeeDateAndRange(s,e,em);
    }
}
