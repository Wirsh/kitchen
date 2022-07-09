package by.mensk.kitchen.service.impl;

import by.mensk.kitchen.dto.bean.ProductBean;
import by.mensk.kitchen.mapper.ProductMapper;
import by.mensk.kitchen.model.Product;
import by.mensk.kitchen.repository.ProductRepository;
import by.mensk.kitchen.service.ProductService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public Product addProduct(String name, Double weight) {
        Product newProduct = new Product(name, weight);
        return repository.save(newProduct);
    }

    @Override
    public void deleteProduct(Integer id) {
        repository.deleteById(id);

    }

    @Override
    public Product updProduct(Product product) {
        Product productFromDb = repository.findById(product.getId()).orElse(null);
         if(Objects.nonNull(productFromDb)&& product.getName()!=null){
             productFromDb.setName(product.getName());
             productFromDb.setWeight(product.getWeight());

         }
        return repository.save(productFromDb);
    }

    @Override
    public List<Product> getProductsList() {
        List<Product> products = new ArrayList<>();
        repository.findAll().forEach(products::add);
        return products;
    }


    @Override
    public Product addProduct(ProductBean productBean) {
        ProductMapper productMapper = new ProductMapper();
        Product newProduct = productMapper.productBeanToProduct(productBean);
        return repository.save(newProduct);
    }

    @Override
    public Product getProduct(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
