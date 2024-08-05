package andersonfflores.ecommerce.Models.Item;

import andersonfflores.ecommerce.Models.Product.ProductDTO;

import java.util.UUID;

public record ItemDTO(UUID id,UUID cart_ID, ProductDTO productDTO, int quantity) {
}
