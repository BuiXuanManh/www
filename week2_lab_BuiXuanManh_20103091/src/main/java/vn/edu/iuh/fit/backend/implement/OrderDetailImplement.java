package vn.edu.iuh.fit.backend.implement;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.backend.models.OrderDetail;
import vn.edu.iuh.fit.backend.repositories.OrderDetailRepository;
import vn.edu.iuh.fit.backend.service.OrderDetailService;

import java.util.List;

public class OrderDetailImplement implements OrderDetailService {
    private OrderDetailRepository repository;

    public OrderDetailImplement() {
        repository= new OrderDetailRepository();
    }

    @Override
    public boolean update(OrderDetail orderDetail) {
        return repository.update(orderDetail);
    }

    @Override
    public List<OrderDetail> findAll() {
        return repository.findAll();
    }

    @Override
    public OrderDetail findById(Long pId, Long OrderId) {
        return repository.findById(pId,OrderId);
    }

    @Override
    public boolean create(OrderDetail orderDetail) {
        return repository.create(orderDetail);
    }
}
