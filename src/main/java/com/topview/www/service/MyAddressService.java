package com.topview.www.service;

import com.topview.www.dao.MyAddressDao;
import com.topview.www.po.MyAddress;
import com.topview.www.po.User;
import com.topview.www.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MyAddressService {
	

	private static volatile MyAddressService instance = null;
	
	public static MyAddressService getInstance() {
		if(instance == null) {
			synchronized(MyAddressService.class) {
				if(instance == null) {
					instance = new MyAddressService();
				}
			}
		}
		return instance;
	}

	/**
	 * 添加我的地址
	 * @param myAddress 数据包括(userId,linkman,phone,address)
	 * @return 添加成功返回true,否则返回false
	 */
	public boolean addMyAddress(MyAddress myAddress) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.getSqlSession();
			MyAddressDao myAddressDao = session.getMapper(MyAddressDao.class);
			int result = myAddressDao.addData(myAddress);
			if(result != 0) {
				return true;
			}
			return false;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

	/**
	 * 根据传入的user对象,获取userId,封装到MyAddress对象中,然后去获取List<MyAddress>集合
	 * @param user 数据包含(userId)
	 * @return 返回查询到的结果集,查询不到,返回null
	 */
	public List<MyAddress> findAllMyAddress(User user) {
		SqlSession session = null;
		try {
			MyAddress myAddress = new MyAddress();
			myAddress.setUserId(user.getUserId());
			session = MyBatisUtil.getSqlSession();
			MyAddressDao myAddressDao = session.getMapper(MyAddressDao.class);
			List<MyAddress> resultList = myAddressDao.selectList(myAddress);
			return resultList;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}


	/**
	 * 根据传入的myAddress对象,往表中更新数据
	 * @param myAddress 数据包括(id,phone,address,linkman)
	 * @return 更新成功返回true,否则返回false
	 */
	public boolean updateMyAddress(MyAddress myAddress) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.getSqlSession();
			MyAddressDao myAddressDao = session.getMapper(MyAddressDao.class);
			int result = myAddressDao.updateData(myAddress);
			if(result != 0) {
				return true;
			}
			return false;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

	/**
	 * 根据id查询MyAddress对象
	 * @param id 做为查询的依据
	 * @return 返回查询到的结果集,查询不到,返回null
	 */
	public MyAddress findMyAddressById(int id) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.getSqlSession();
			MyAddressDao myAddressDao = session.getMapper(MyAddressDao.class);
			MyAddress myAddress = myAddressDao.findMyAddressById(id);
			return myAddress;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

	public boolean deleteMyAddress(int myAddressId) {
		SqlSession session = null;
		try {
			session = MyBatisUtil.getSqlSession();
			MyAddressDao myAddressDao = session.getMapper(MyAddressDao.class);
			int result = myAddressDao.deleteMyAddress(myAddressId);
			if(result != 0) {
				return true;
			}
			return false;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

}
