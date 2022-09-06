package by.mensk.kitchen.service;

import by.mensk.kitchen.dto.bean.MealBean;
import by.mensk.kitchen.model.Meal;
import by.mensk.kitchen.model.Product;

import java.util.List;


public interface MealService {

    List<Product> getIngridients(Integer mealId);
//    void  addMeal();
    Integer getAmount(Integer id);
    Meal setPortionsNum(Integer id, Integer amount);
    Meal createMeal(Meal meal);
    Meal createMeal(MealBean mealBean);


    Meal findById(Integer id);

    Meal updateMeal(Meal meal);

    List<MealBean> getMealBeansList();
    List<Meal> getMealList();

    MealBean getMealBean(Integer id);
}
