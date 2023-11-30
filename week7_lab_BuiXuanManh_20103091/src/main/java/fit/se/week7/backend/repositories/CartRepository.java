package fit.se.week7.backend.repositories;

import fit.se.week7.backend.models.Cart;
import fit.se.week7.backend.pks.CartKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, CartKey> {
}
