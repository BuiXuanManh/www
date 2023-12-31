package iuh.fit.week2.implement;

import iuh.fit.week2.models.OrderDetail;
import iuh.fit.week2.repositories.OrderDetailRepository;
import iuh.fit.week2.services.OrderDetailService;

public class OrderDetailImplement implements OrderDetailService {
    private OrderDetailRepository repository;

    public OrderDetailImplement() {
        repository= new OrderDetailRepository();
    }

    @Override
    public boolean create(OrderDetail orderDetail) {
        return repository.create(orderDetail);
    }
}
