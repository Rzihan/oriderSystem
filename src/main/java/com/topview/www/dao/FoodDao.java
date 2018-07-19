package com.topview.www.dao;

import com.topview.www.po.Food;
import com.topview.www.bo.CheckFood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FoodDao extends BaseDao<Food>{

    int changeFoodState(Food food);

    List<Food> findFoodsByStoreId(int storeId);

    List<CheckFood> getCheckingFoods();

    int updateFoodNum(@Param("foodNum")int foodNum, @Param("id")int id);

    int getPutAwayFoodsAllTotalBySearch(@Param("foodState")int foodState, @Param("search")String search);

    List<Food> getPutAwayFoodsBySearch(@Param("foodState")int foodState, @Param("search")String search,
                                       @Param("startRow")int startRow, @Param("pageSize")int pageSize);

    int getPutAwayFoodsAllTotalByStoreId(@Param("foodState")int foodState, @Param("storeId")int storeId);

    List<Food> getPutAwayFoodsByStoreId(@Param("foodState")int foodState, @Param("storeId")int storeId,
                                        @Param("startRow")int startRow, @Param("pageSize")int pageSize);
}
