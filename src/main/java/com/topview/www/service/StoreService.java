package com.topview.www.service;

import com.topview.www.constant.RoleConstants;
import com.topview.www.constant.StoreConstants;
import com.topview.www.dao.StoreDao;
import com.topview.www.po.Store;
import com.topview.www.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 店铺业务逻辑处理类
 * 采用单例设计模式
 */
public class StoreService {

	private static volatile StoreService instance = null;
	
	private StoreService() {}

	public static StoreService getInstance() {
		if(instance == null) {
			synchronized(StoreService.class) {
				if(instance == null) {
					instance = new StoreService();
				}
			}
		}
		return instance;
	}

	/**
	 * 根据userId获取对应的Store
	 * @param userId 用户id
	 * @return 查询到返回对应的Store,否则返回null
	 */
	public Store getStoreByUserId(int userId) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.getSqlSession();
			StoreDao storeDao = session.getMapper(StoreDao.class);
			Store store = storeDao.getStoreByUserId(userId);
			return store;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

	/**
	 * 开店申请业务逻辑处理类
	 * @param store 数据包括(userId,storeName,storeType,storeComments,storeAddress,storeLogo)
	 * @return 数据修改成功,返回true,否则返回false
	 */
	public boolean applyForStore(Store store) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.getSqlSession();
			StoreDao storeDao = session.getMapper(StoreDao.class);
			int result = storeDao.addData(store);
			return result != 0;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

	/**
	 * 系统管理批准用户开店
	 * @param store (id,userId,apply_for_state)
	 * @return 更新成功返回true,否则返回false
	 */
	public boolean approvalApply(Store store) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.getSqlSession();
			StoreDao storeDao = session.getMapper(StoreDao.class);
			//往store插入数据操作
			int result = storeDao.updateApplyForState(store);
			if(result == 0) {
				return false;
			}
 			//往用户角色表插入数据
			result = storeDao.addUserAndRoleData(store.getUserId(), RoleConstants.ROLE_STORE);
			return result != 0;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}


	/**
	 * 系统管理查找所有审核成功还有未审核的店铺
	 * @return 返回查询结果集,若不存在,返回null
	 */
	public List<Store> findAllApplyForStore() {
		SqlSession session = null;
		try {
			session = MyBatisUtil.getSqlSession();
			StoreDao storeDao = session.getMapper(StoreDao.class);
			List<Store> resultList = storeDao.findAllApplyForStore();
			return resultList;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

	/**
	 * 系统管理员拒绝开店申请
	 * @return 修改数据成功,返回true,否则返回false
	 */
	public boolean rejectApplyFor(Store store) {
		SqlSession session = null;
		try {
			store.setApplyForState(StoreConstants.CHECK_FAILURE);
			session = MyBatisUtil.getSqlSession();
			StoreDao storeDao = session.getMapper(StoreDao.class);
			int result = storeDao.updateApplyForState(store);
			return result != 0;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}


	/**
	 * 系统管理员关闭开店
	 * @return 修改数据成功,返回true,否则返回false
	 */
	public boolean colseStore(Store store) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.getSqlSession();
			store.setApplyForState(StoreConstants.CHECK_FAILURE);
			StoreDao storeDao = session.getMapper(StoreDao.class);
			// 更新店铺的状态为审核失败
			int result = storeDao.updateApplyForState(store);
			if(result == 0) {
				return false;
			}
			// 删除用户角色表中的对应数据
			result = storeDao.deleteUserAndRoleData(store.getUserId(), RoleConstants.ROLE_STORE);
			return result != 0;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}



}
