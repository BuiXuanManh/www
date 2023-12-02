package fit.se.week7.backend.implement;

import fit.se.week7.backend.models.OrderDetail;
import fit.se.week7.backend.pks.OrderDetailPK;
import fit.se.week7.backend.repositories.OrderDetailsRepository;
import fit.se.week7.backend.services.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderDetailsImpl implements OrderDetailsService {
    @Autowired
    private OrderDetailsRepository repository;
    @Override
    public List<OrderDetail> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<OrderDetail> findBYId(OrderDetailPK orderDetailPK) {
        return repository.findById(orderDetailPK);
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return repository.save(orderDetail);
    }
}
