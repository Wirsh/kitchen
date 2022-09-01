package by.mensk.kitchen.service;

import by.mensk.kitchen.dto.bean.ProductBean;
import by.mensk.kitchen.model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(String name, Double weight);
    void deleteProduct(Integer id);
    Product updProduct(Product product);

    List<Product> getUsedProductsList(List<ProductBean> productBeansList);

    List<Product> getProductsList();

    Product addProduct(ProductBean productBean);

    Product getProduct(Integer id);

    List<ProductBean> getProductsBeansByIdIn(List<Integer> collect);
    List<ProductBean> getProductsBeansList();
    List<Product> getProductsByIdIn(List<Integer> collect);

    List<Product> getProductsList(List<ProductBean> products);
}
