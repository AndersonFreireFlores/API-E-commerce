package andersonfflores.ecommerce.Repositories;

import andersonfflores.ecommerce.Models.Item.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ItemRepository extends CrudRepository<Item, UUID> {

}
