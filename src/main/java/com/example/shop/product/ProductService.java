package com.example.shop.product;

import com.example.shop.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Long createProduct(ProductCreateRequest request) {
        Product existingProduct = productRepository.findById(request.getProductId);
        if (existingProduct != null) {
            throw new RuntimeException("Product already exists");
        }
        Product product = new Product(
                request.getProductId(),
                request.getProductName()
        );
        productRepository.save(product);
        return product.getId();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        Product product = productRepository.findById(id);
        if (product == null) {
            throw new RuntimeException("Product not found");
        }
        return product;
    }

    public void updateProduct(Long id,ProductUpdateRequest request){
        Product product=productRepository.findById(id);
        if (product == null) {
            throw new RuntimeException("Product not found");
        }
        product.updateInfo(request.getProductName());
    }

    public void deleteProduct(Long id){
        Product product=productRepository.findById(id);
        if( product == null ) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }
}
