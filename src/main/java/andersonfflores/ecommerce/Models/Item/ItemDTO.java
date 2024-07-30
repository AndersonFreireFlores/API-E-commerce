package andersonfflores.ecommerce.Models.Item;

import java.util.UUID;

public record ItemDTO(UUID id, String carrinhoId, String produtoId, int quantidade) {
}
