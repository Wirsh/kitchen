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
import java.util.stream.Collectors;

@Data
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public Product addProduct(String name, Double weight) {
        Product newProduct = new Product();
        return repository.save(newProduct);
    }

    @Override
    public void deleteProduct(Integer id) {
        repository.deleteById(id);

    }

    @Override
    public Product updProduct(Product product) {
        Product productFromDb = repository.findById(product.getId()).orElse(null);
        if (Objects.nonNull(productFromDb) && product.getName() != null) {
            productFromDb.setName(product.getName());
            productFromDb.setWeight(product.getWeight());

        }
        return repository.save(productFromDb);
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

    @Override
    public List<ProductBean> getProductsBeansByIdIn(List<Integer> collect) {
        List<ProductBean> productBeans = new ArrayList<>();
        ProductMapper productMapper = new ProductMapper();
        repository.findAllById(collect)
                .stream()
                .forEach(product -> productBeans.add(productMapper.productToProductBean(product)) );
        return productBeans;
    }

    @Override
    public List<ProductBean> getProductsBeansList() {
        List<ProductBean> productBeans = new ArrayList<>();
        ProductMapper productMapper = new ProductMapper();
        repository.findAll()
                .stream()
                .forEach(product -> productBeans.add(productMapper.productToProductBean(product)) );
        return productBeans;
    }

    @Override
    public List<Product> getProductsByIdIn(List<Integer> collect) {
        return repository.findAllById(collect);
    }

    @Override
    public List<Product> getProductsList(List<ProductBean> products) {
        List<Product> productList = products
                .stream()
                .map(ProductMapper::productBeanToProduct)
                .toList();
        return productList;
    }

    @Override
    public List<Product> getUsedProductsList(List<ProductBean> productBeansList) {
        ProductMapper productMapper = new ProductMapper();
        List<Product> products = null;
        productBeansList
                .stream()
                .filter(ProductBean::getIsUsed)
                .forEach(productBean -> products.add(productMapper.productBeanToProduct(productBean)));
        return repository.findAllById(products
                .stream()
                .map(Product::getId)
                .collect(Collectors.toList()));
    }
    @Override
    public List<Product> getProductsList() {
        List<Product> products = new ArrayList<>();
        repository.findAll().forEach(products::add);
        return products;
    }
}
