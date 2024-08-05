package andersonfflores.ecommerce.Services;

import andersonfflores.ecommerce.Models.Item.Item;
import andersonfflores.ecommerce.Models.Item.ItemDTO;
import andersonfflores.ecommerce.Models.Product.Product;
import andersonfflores.ecommerce.Models.Product.ProductDTO;
import andersonfflores.ecommerce.Repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemDTO> getAllItems() {
        return itemRepository.findAllItems();
    }

    public ItemDTO getItemById(UUID id) {
        Item item = itemRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Item not found")
        );
        return new ItemDTO(
                item.getId(),
                item.getCart().getId(),
                itemRepository.findProductDTOByProductId(item.getProduct().getId()),
                item.getQuantity()
        );
    }

    public ItemDTO saveItem(ItemDTO itemDTO) {
        ProductDTO productDTO = itemRepository.findProductDTOByProductId(itemDTO.productDTO().id());
        Item item = new Item(
                itemRepository.findCartByCartID(itemDTO.cart_ID()),
                new Product(
                        productDTO.id(),
                        productDTO.name(),
                        productDTO.description(),
                        productDTO.img_Url(),
                        productDTO.price()
                ),
                itemDTO.quantity()
                );
        itemRepository.save(item);
        return itemDTO;
    }

    public ItemDTO update (UUID id,ItemDTO itemDTO){
        Item item = itemRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Item not found")
        );
        ProductDTO productDTO = itemRepository.findProductDTOByProductId(itemDTO.productDTO().id());
        item.setCart(itemRepository.findCartByCartID(itemDTO.cart_ID()));
        item.setProduct(new Product(
                productDTO.id(),
                productDTO.name(),
                productDTO.description(),
                productDTO.img_Url(),
                productDTO.price()
        ));
        item.setQuantity(itemDTO.quantity());
        itemRepository.save(item);
        return itemDTO;
    }

    public void deleteItemById(UUID id) {
        itemRepository.deleteById(id);
    }
}
