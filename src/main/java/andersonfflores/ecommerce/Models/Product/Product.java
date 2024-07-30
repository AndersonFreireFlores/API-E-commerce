package andersonfflores.ecommerce.Models.Product;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Table("product")
public class Product {

    @Id
    private UUID id;

    private String name;

    private String description;

    private String img_Url;

    private BigDecimal price;

    public Product() {
    }


    public Product(UUID id, String name, String description, String img_Url, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.img_Url = img_Url;
        this.price = price;
    }

    public Product(String name, String description, String img_Url, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.img_Url = img_Url;
        this.price = price;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImg_Url() {
        return img_Url;
    }

    public void setImg_Url(String img_Url) {
        this.img_Url = img_Url;
    }
}
