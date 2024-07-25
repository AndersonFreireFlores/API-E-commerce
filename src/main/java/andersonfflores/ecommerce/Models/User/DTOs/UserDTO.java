package andersonfflores.ecommerce.Models.User.DTOs;

import java.util.UUID;

public record UserDTO (UUID id, String name, String email){
}
