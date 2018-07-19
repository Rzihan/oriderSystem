package com.topview.www.service;

import com.topview.www.bo.Page;
import com.topview.www.constant.FoodConstants;
import com.topview.www.dao.FoodDao;
import com.topview.www.po.Food;
import com.topview.www.util.MyBatisUtil;
import com.topview.www.bo.CheckFood;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * food业务逻辑处理类
 */
public class FoodService {
	
	private static volatile FoodService instance = null;

	private FoodService() {}

	public static FoodService getInstance() {
		if(instance == null) {
			synchronized(FoodService.class) {
				if(instance == null) {
					instance = new FoodService();
				}
			}
		}
		return instance;
	}

	/**
	 * 根据店铺id查询所有食物
	 * @param storeId 店铺的id
	 * @return 返回查询结果集
	 */
	public List<Food> findFoodsByStoreId(int storeId) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.getSqlSession();
			FoodDao foodDao = session.getMapper(FoodDao.class);
			return foodDao.findFoodsByStoreId(storeId);
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

	/**
	 * 添加食物数据到表中
	 * @param food 数据包括(storeId,foodName,foodPrice,foodComments,foodType,foodImage)
	 * @return 添加数据成功则返回true,否则返回false
	 */
	public boolean addFood(Food food) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.getSqlSession();
			FoodDao foodDao = session.getMapper(FoodDao.class);
			int result = foodDao.addData(food);
			return result != 0;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

	/**
	 * 改变食物状态的业务逻辑
	 * @param idStr 要修改的食物id的字符串形式
	 * @param operate 要进行的操作
	 * @return 修改成功返回true,否则返回false
	 */
	public boolean changeFoodState(String idStr,String operate) {
		int id = Integer.parseInt(idStr);//将id转换成int类型
		Food food = new Food();
		food.setId(id);//设置食物的id
		//根据获得的operate信息，设置食物对象的state
		switch (operate) {
			case FoodConstants.SUBMIT_CHECK://提交审核
				food.setFoodState(FoodConstants.FOOD_BEING_CHECK);
				break;
			case FoodConstants.PUT_AWAY://上架
				food.setFoodState(FoodConstants.FOOD_PUTAWAY);
				break;
			case FoodConstants.SALE_OUT://下架
				food.setFoodState(FoodConstants.FOOD_SALE_OUT);
				break;
			case FoodConstants.CHECK_SUCCESS://审核成功
				food.setFoodState(FoodConstants.FOOD_CHECK_SUCCESS);
				break;
			case FoodConstants.CHECK_FAILURE://审核失败
				food.setFoodState(FoodConstants.FOOD_CHECK_FAILURE);
				break;
			case FoodConstants.DELETE://删除
				food.setFoodState(FoodConstants.FOOD_DELETE);
				break;
		}
		SqlSession session = null;
		try {
			session = MyBatisUtil.getSqlSession();
			FoodDao foodDao = session.getMapper(FoodDao.class);
			int result;
			if(food.getFoodState() == FoodConstants.FOOD_DELETE) {
				result = foodDao.removeData(food);
			}else {
				result = foodDao.changeFoodState(food);
			}
			return result != 0;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}


	/**
	 * 查找所有处于审核状态的Food
	 * @return List<CheckFood>
	 */
	public List<CheckFood> getCheckingFoods() {
		SqlSession session = null;
		try {
			session = MyBatisUtil.getSqlSession();
			FoodDao foodDao = session.getMapper(FoodDao.class);
			return foodDao.getCheckingFoods();
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

	/**
	 * 更新食物的库存
	 * @param food 食物的库存
	 * @return 修改成功返回true,否则返回false
	 */
	public boolean updateFoodNum(Food food) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.getSqlSession();
			FoodDao foodDao = session.getMapper(FoodDao.class);
			int result = foodDao.updateFoodNum(food.getFoodNum(), food.getId());
			return result != 0;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

	/**
	 * 用户根据搜索条件获取List<Food>并将其放入page.list中
	 * @param search 搜索条件
	 * @param foodPage 分页对象
	 */
	public void getPutAwayFoodsBySearch(String search, Page<Food> foodPage) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.getSqlSession();
			FoodDao foodDao = session.getMapper(FoodDao.class);
			int total = foodDao.getPutAwayFoodsAllTotalBySearch(FoodConstants.FOOD_PUTAWAY, "%" + search + "%");
			foodPage.setTotalRecord(total);
			int startRow = (foodPage.getCurrentPage() - 1 ) * foodPage.getPageSize();
			List<Food> foodList = foodDao.getPutAwayFoodsBySearch(FoodConstants.FOOD_PUTAWAY, "%" + search + "%",
					startRow, foodPage.getPageSize());
			foodPage.setList(foodList);
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

	/**
	 * 用户根据搜索条件获取List<Food>并将其放入page.list中
	 * @param storeId 搜索条件
	 * @param foodPage 分页对象
	 */
	public void getPutAwayFoodsByStoreId(int storeId, Page<Food> foodPage) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.getSqlSession();
			FoodDao foodDao = session.getMapper(FoodDao.class);
			int total = foodDao.getPutAwayFoodsAllTotalByStoreId(FoodConstants.FOOD_PUTAWAY, storeId);
			foodPage.setTotalRecord(total);
			int startRow = (foodPage.getCurrentPage() - 1) * foodPage.getPageSize();
			List<Food> resultList = foodDao.getPutAwayFoodsByStoreId(FoodConstants.FOOD_PUTAWAY, storeId,
					startRow, foodPage.getPageSize());
			foodPage.setList(resultList);
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}


	public Food getFoodByFoodId(int foodId) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.getSqlSession();




		} finally {
			MyBatisUtil.closeSession(session);
		}


		return null;
	}



}
