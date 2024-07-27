package andersonfflores.ecommerce.Models.Cart;

import andersonfflores.ecommerce.Models.Item.Item;
import andersonfflores.ecommerce.Models.User.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Table("cart")
public class Cart {

    @Id
    private UUID id;

    private User user;

    private BigDecimal total_price;

    private List<Item> items;

    public Cart() {
    }

    public Cart(UUID id, User user, BigDecimal total_price, List<Item> items) {
        this.id = id;
        this.user = user;
        this.total_price = total_price;
        this.items = items;
    }

    public Cart(User user, BigDecimal total_price, List<Item> items) {
        this.user = user;
        this.total_price = total_price;
        this.items = items;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
