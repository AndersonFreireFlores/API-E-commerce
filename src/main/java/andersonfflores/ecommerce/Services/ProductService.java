package andersonfflores.ecommerce.Services;

import andersonfflores.ecommerce.Models.Product.Product;
import andersonfflores.ecommerce.Models.Product.ProductDTO;
import andersonfflores.ecommerce.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAllProducts();
    }

    public ProductDTO getProductById(UUID id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Product not found")
        );
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getImg_Url(),
                product.getPrice()
        );
    }

    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = new Product(
                productDTO.name(),
                productDTO.description(),
                productDTO.img_Url(),
                productDTO.price()
        );
        productRepository.save(product);
        return productDTO;
    }

    public ProductDTO updateProduct(UUID id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Product not found")
        );
        product.setName(productDTO.name());
        product.setDescription(productDTO.description());
        product.setImg_Url(productDTO.img_Url());
        product.setPrice(productDTO.price());
        productRepository.save(product);
        return productDTO;
    }

    public void deleteProductById(UUID id) {
        productRepository.deleteById(id);
    }
}
