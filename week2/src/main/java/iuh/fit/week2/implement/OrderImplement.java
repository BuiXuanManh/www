package iuh.fit.week2.implement;

import iuh.fit.week2.models.Order;
import iuh.fit.week2.repositories.OrderRepository;
import iuh.fit.week2.services.OrderService;
import jakarta.inject.Inject;

import java.util.List;

public class OrderImplement implements OrderService {
//    @Inject
//    private OrderRepository orderRepository;
    private OrderRepository repository= new OrderRepository();
    @Override
    public boolean create(Order o) {
        return repository.create(o);
    }

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }
}
