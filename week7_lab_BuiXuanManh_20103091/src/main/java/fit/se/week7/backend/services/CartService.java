package fit.se.week7.backend.services;

import fit.se.week7.backend.models.Cart;
import fit.se.week7.backend.pks.CartKey;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service
public interface CartService {
    List<Cart> getAll();
    Cart save(Cart cart);
    Optional<Cart> findById(CartKey cartKey);
}
