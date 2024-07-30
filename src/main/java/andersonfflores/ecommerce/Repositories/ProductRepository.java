package andersonfflores.ecommerce.Repositories;

import andersonfflores.ecommerce.Models.Product.Product;
import andersonfflores.ecommerce.Models.Product.ProductDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {

    @Query(value = "select * from product")
    List<ProductDTO> findAllProducts();

}
