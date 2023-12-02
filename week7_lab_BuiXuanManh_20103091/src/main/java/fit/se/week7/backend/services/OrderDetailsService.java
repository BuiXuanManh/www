package fit.se.week7.backend.services;

import fit.se.week7.backend.models.OrderDetail;
import fit.se.week7.backend.pks.OrderDetailPK;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderDetailsService {
    List<OrderDetail> getAll();
    Optional<OrderDetail> findBYId(OrderDetailPK orderDetailPK);
    OrderDetail save(OrderDetail orderDetail);
}
