package com.topview.www.dao;

import com.topview.www.po.Food;
import com.topview.www.bo.CheckFood;

import java.util.List;

public interface FoodDao extends BaseDao<Food>{

    int changeFoodState(Food food);

    List<Food> findFoodsByStoreId(int storeId);

    List<CheckFood> getCheckingFoods();
}
