package by.mensk.kitchen.service.impl;

import by.mensk.kitchen.dto.bean.MealBean;
import by.mensk.kitchen.mapper.MealMapper;
import by.mensk.kitchen.model.Meal;
import by.mensk.kitchen.model.Product;
import by.mensk.kitchen.repository.MealRepository;
import by.mensk.kitchen.repository.ProductRepository;
import by.mensk.kitchen.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MealServiceImpl implements MealService {
    @Autowired
    private MealRepository repository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getIngridients(Integer mealId) {
        MealBean mealBean = getMealBean(mealId);
        return mealBean != null ? mealBean.getProducts() : null;
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
        if (meal.getName() != null) {
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

    @Override
    public Meal updateMeal(Meal meal) {
        Meal mealFromDb = repository.findById(meal.getId()).orElse(null);
        if (Objects.nonNull(mealFromDb) && meal.getName() != null) {
            mealFromDb.setName(meal.getName());
            mealFromDb.setType(meal.getType());
            mealFromDb.setProducts(meal.getProducts());
            mealFromDb.setCategory(meal.getCategory());
            mealFromDb.setAmount(meal.getAmount());

        }
        return repository.save(mealFromDb);

    }

    @Override
    public List<MealBean> getMealBeansList() {
        return null;
    }

    @Override
    public List<Meal> getMealList() {
        return repository.findAll();
    }

    @Override
    public MealBean getMealBean(Integer id) {
        MealMapper mapper = new MealMapper();
        MealBean mealBean = mapper.mealToMealBean(repository.findById(id).orElse(null));
        return mealBean;
    }
}
