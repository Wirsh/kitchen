package by.mensk.kitchen.service;

import by.mensk.kitchen.dto.bean.ProductBean;
import by.mensk.kitchen.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    Product addProduct(String name, Double weight);
    void deleteProduct(Integer id);
    Product updProduct(Product product);
    List<Product> getProductsList();

    Product addProduct(ProductBean productBean);

    Product getProduct(Integer id);
}
