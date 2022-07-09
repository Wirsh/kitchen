package by.mensk.kitchen.service.impl;

import by.mensk.kitchen.dto.bean.MealBean;
import by.mensk.kitchen.mapper.MealMapper;
import by.mensk.kitchen.model.Meal;
import by.mensk.kitchen.model.Product;
import by.mensk.kitchen.repository.MealRepository;
import by.mensk.kitchen.repository.ProductRepository;
import by.mensk.kitchen.service.MealService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MealServiceImpl implements MealService {
    private MealRepository repository;
    private MealService service;
    private ProductRepository productRepository;

    @Override
    public List<Product> getIngridients() {
        return productRepository.findAll();
    }

    @Override
    public Integer getAmount(Integer id) {
        Meal newMeal = repository.findById(id).get();
        return newMeal.getAmount();
    }

    @Override
    public Meal setPortionsNum(Integer id, Integer amount) {
        Meal mealToUpd = repository.findById(id).get();
        mealToUpd.setAmount(amount);

        return repository.save(mealToUpd);
    }

    @Override
    public Meal createMeal(Meal meal) {
        Meal createdMeal = null;
        if (meal.getName() != null && !meal.getProducts().isEmpty()) {
            createdMeal = repository.save(meal);
        }
        return createdMeal;
    }

    @Override
    public Meal createMeal(MealBean mealBean) {
        MealMapper mapper = new MealMapper();
        Meal newMeal = mapper.mealBeanToMeal(mealBean);
        return repository.save(newMeal);
    }

    @Override
    public Meal findById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
