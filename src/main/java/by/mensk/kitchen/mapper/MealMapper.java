package by.mensk.kitchen.mapper;

import by.mensk.kitchen.dto.bean.MealBean;
import by.mensk.kitchen.model.Meal;

public class MealMapper {
    public MealBean mealToMealBean(Meal meal){
        MealBean mealBean = new MealBean();
        mealBean.setName(meal.getName());
        mealBean.setAmount(mealBean.getAmount());
        mealBean.setCategory(mealBean.getCategory());
        mealBean.setProducts(meal.getProducts());
        mealBean.setType(meal.getType());
        return mealBean;
    }
    public Meal mealBeanToMeal(MealBean mealBean){
        Meal meal = new Meal();
        meal.setName(mealBean.getName());
        meal.setAmount(mealBean.getAmount());
        meal.setCategory(mealBean.getCategory());
        meal.setProducts(mealBean.getProducts());
        meal.setType(mealBean.getType());
        return meal;
    }
}
