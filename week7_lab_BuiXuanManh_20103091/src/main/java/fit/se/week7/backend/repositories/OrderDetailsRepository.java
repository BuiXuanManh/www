package fit.se.week7.backend.repositories;

import fit.se.week7.backend.models.OrderDetail;
import fit.se.week7.backend.pks.OrderDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetail, OrderDetailPK> {
}
