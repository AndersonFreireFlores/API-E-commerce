package andersonfflores.ecommerce.Repositories;

import andersonfflores.ecommerce.Models.Cart.Cart;
import andersonfflores.ecommerce.Models.Item.Item;
import andersonfflores.ecommerce.Models.Item.ItemDTO;
import andersonfflores.ecommerce.Models.Product.ProductDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ItemRepository extends CrudRepository<Item, UUID> {

    @Query(value = "SELECT item.id,item.carrinho_id,product.id,product.name, product.description, product.img_url,product.price, item.quantity " +
            "from item join product on item.product_id = product.id")
    List<ItemDTO> findAllItems();

    @Query(value = "SELECT * from product where product.id = :id")
    ProductDTO findProductDTOByProductId(UUID id);

    @Query(value = "SELECT * from cart where cart.id = :id")
    Cart findCartByCartID(UUID id);


}
