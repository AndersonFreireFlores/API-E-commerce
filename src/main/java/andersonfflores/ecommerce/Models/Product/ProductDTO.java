package andersonfflores.ecommerce.Models.Product;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductDTO(UUID id, String name, String description, String img_Url, BigDecimal price) {
}
