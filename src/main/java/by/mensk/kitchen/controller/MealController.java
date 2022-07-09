package by.mensk.kitchen.controller;

import by.mensk.kitchen.dto.bean.MealBean;
import by.mensk.kitchen.model.Meal;
import by.mensk.kitchen.model.Product;
import by.mensk.kitchen.repository.MealRepository;
import by.mensk.kitchen.service.MealService;
import by.mensk.kitchen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MealController {
    @Autowired
    public MealService mealService;
    @Autowired
    public ProductService productService;

    @GetMapping("/create_meal_form")
    public String createMealForm(Model model) {
        Meal newMeal = new Meal();
        model.addAttribute("new_meal", newMeal);
        List<Product> productsList = productService.getProductsList();
        model.addAttribute("product_list", productsList);
        return "create_meal_form";
    }

    @PostMapping("/add_meal")
    public String addMeal(MealBean mealBean, Model model) {

        mealService.createMeal(mealBean);
        return "/redirect:create_meal_form";
    }

     @RequestMapping(value="/add_meal", method = RequestMethod.POST)
        public String addProductToMeal (@Validated String s) {
    return "redirect:/courier";
}


    @GetMapping("/meal/{meal_id}")
    public Meal getMeal(@PathVariable(name = "meal_id") Integer id) {
        return mealService.findById(id);
    }

}
