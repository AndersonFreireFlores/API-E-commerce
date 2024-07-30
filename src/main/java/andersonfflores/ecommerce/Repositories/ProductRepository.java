package andersonfflores.ecommerce.Repositories;

import andersonfflores.ecommerce.Models.Product.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {
}
