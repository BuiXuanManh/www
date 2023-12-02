package fit.se.week7.backend.services;

import fit.se.week7.backend.models.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    List<Order> getAll();
    Order save(Order order);
    Optional<Order> findById(Long id);
}
