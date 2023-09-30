package vn.edu.iuh.fit.backend.service;


import vn.edu.iuh.fit.backend.models.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    boolean create(OrderDetail orderDetail);
    boolean update(OrderDetail orderDetail);
    List<OrderDetail> findAll();
    OrderDetail findById(Long pId, Long OrderId);
}
