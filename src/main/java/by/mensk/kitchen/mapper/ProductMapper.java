package by.mensk.kitchen.mapper;

import by.mensk.kitchen.dto.bean.ProductBean;
import by.mensk.kitchen.model.Product;

public class ProductMapper {
    public ProductBean productToProductBean(Product product){
        ProductBean productBean = new ProductBean();
        productBean.setName(product.getName());
        return productBean;
    }


    public Product productBeanToProduct(ProductBean productBean){
        Product product = new Product();
        product.setName(productBean.getName());
        return product;
    }
}
