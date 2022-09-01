package by.mensk.kitchen.controller;

import by.mensk.kitchen.dto.bean.Ingridients;
import by.mensk.kitchen.dto.bean.MealBean;
import by.mensk.kitchen.dto.bean.ProductBean;
import by.mensk.kitchen.model.Meal;
import by.mensk.kitchen.model.Product;
import by.mensk.kitchen.service.MealService;
import by.mensk.kitchen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MealController {
    @Autowired
    public MealService mealService;
    @Autowired
    public ProductService productService;

    //    @GetMapping("/create_meal_form")
//    public String createMealForm(Model model) {
//        MealBean newMeal = new MealBean();
//        model.addAttribute("new_meal", newMeal);
//        List<ProductBean> productsList = productService.getProductsBeansList()
//                .stream()
//                .peek(x -> x.setIsUsed(false))
//                .collect(Collectors.toList());
//        model.addAttribute("product_list", productsList);
//        return "create_meal_form";
//    }
    @GetMapping("/add_meal_form")
    public String addMealForm(Model model) {
        MealBean mealBean = new MealBean();
        model.addAttribute("newMeal", mealBean);
        return "add_meal_form";

    }

    @PostMapping("/add_meal")
    //todo Meal to MealBean
    public String addMeal(MealBean meal) {
        mealService.createMeal(meal);

        return "redirect:/get_meal_list";
    }

    @GetMapping("/get_meal_list")
    public String mealList(Model model) {
        List<Meal> mealList = mealService.getMealList();
        model.addAttribute("meals", mealList);
        return "get_meal_list";

    }
    @GetMapping("/get_ingridients/{id}")
    public String getIngridients(@PathVariable Integer id, Model model) {
        List<Product> ingridients = mealService.getIngridients(id);
        model.addAttribute("meal",mealService.getMealBean(id));
        model.addAttribute("ingridients", ingridients);

        return "/get_ingridients";

    }


    @GetMapping("/add_product_to_meal")
    public String addProductToMeal(Meal meal, Model model) {
        model.addAttribute("meal", meal);

        return "/redirect:create_meal_form";
    }

    @GetMapping("/update_meal/{id}")
    public String updProductForm(@PathVariable(name = "id") Integer id, Model model) {
        List<ProductBean> products = productService.getProductsBeansList()
                .stream()
                .peek(x -> x.setIsUsed(false))
                .collect(Collectors.toList());
        Meal meal = mealService.findById(id);
        model.addAttribute("meal", meal);
        model.addAttribute("products", products);
        Ingridients ingridients = new Ingridients();
//        products.stream().forEach(productBean -> model.addAttribute("isAdded",productBean.getIsUsed()));
        ingridients.setProducts(products);
        model.addAttribute("ingridients", ingridients);
        return "upd_meal_form";
    }

    @PostMapping("/update_meal/{id}")
    public String updMeal(Ingridients ingridients, Meal meal , Model model) {
        model.addAttribute("ingridients", ingridients);
        model.addAttribute("meal", meal);
        meal.setProducts(productService.getUsedProductsList(ingridients.getProducts()));
        mealService.updateMeal(meal);
        return "redirect:/get_meal_list";
    }

//    @GetMapping("/delete_product/{id}")
//    public String deleteProduct(@PathVariable(name = "id") Integer id) {
//         productService.deleteProduct(id);
//        return "redirect:/get_product_list";
//
//    }

//     @RequestMapping(value="/add_meal", method = RequestMethod.POST)
//        public String addProductToMeal (@Validated String s) {
//    return "redirect:/courier";
//}


    @GetMapping("/meal/{meal_id}")
    public Meal getMeal(@PathVariable(name = "meal_id") Integer id) {
        return mealService.findById(id);
    }

}
