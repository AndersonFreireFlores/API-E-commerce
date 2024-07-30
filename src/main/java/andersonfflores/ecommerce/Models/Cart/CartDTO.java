package andersonfflores.ecommerce.Models.Cart;

import andersonfflores.ecommerce.Models.Item.ItemDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record CartDTO(UUID id, String userId, BigDecimal totalPrice, List<ItemDTO> items) {
}
