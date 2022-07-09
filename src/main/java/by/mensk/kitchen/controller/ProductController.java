package by.mensk.kitchen.controller;

import by.mensk.kitchen.dto.bean.ProductBean;
import by.mensk.kitchen.model.Product;
import by.mensk.kitchen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    public ProductService productService;

    @GetMapping("/add_product_form")
    public String regPage(Model model) {
        ProductBean productBean = new ProductBean();
        model.addAttribute("newProduct", productBean);
        return "add_product_form";

    }
    @PostMapping("/add_product")
    public String addProduct(ProductBean newProduct) {
       productService.addProduct(newProduct);
        return "redirect:/get_product_list";
    }
    @GetMapping("/get_product_list")
    public String productList (Model model) {
        List<Product> productsList = productService.getProductsList();
        model.addAttribute("products", productsList);
        return "get_product_list";

    }

    @GetMapping("/update_product/{id}")
    public String updProductForm(@PathVariable(name = "id") Integer id, Model model){
        Product product = productService.getProduct(id);
        model.addAttribute("product_to_update",product);
        return "upd_product_form";
    }
    @PostMapping("/update_product/{id}")
    public String updProduct(Product product, Model model){
        model.addAttribute("product_to_update",product);
        productService.updProduct(product);
        return "redirect:/get_product_list";
    }

    @GetMapping("/delete_product/{id}")
    public String deleteProduct(@PathVariable(name = "id") Integer id) {
         productService.deleteProduct(id);
        return "redirect:/get_product_list";

    }



}
