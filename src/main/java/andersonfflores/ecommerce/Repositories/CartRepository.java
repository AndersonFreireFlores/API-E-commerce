package andersonfflores.ecommerce.Repositories;

import andersonfflores.ecommerce.Models.Cart.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CartRepository extends CrudRepository<Cart, UUID> {

}
