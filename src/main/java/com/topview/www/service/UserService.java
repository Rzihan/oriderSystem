package com.topview.www.service;

import com.topview.www.constant.AdminPathConstants;
import com.topview.www.constant.RoleConstants;
import com.topview.www.constant.StorePathConstants;
import com.topview.www.constant.UserPathConstants;
import com.topview.www.dao.UserDao;
import com.topview.www.po.User;
import com.topview.www.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 用户业务逻辑类
 * 考虑到该类经常被使用，采用单例设计模式
 */
public class UserService {

	private static final String PHONE_NUMBER_HAS_BEEN_REGISTERED = "手机号已经被注册";
	private static final String LOGIN_ID_OR_PASSWORD_ERROR = "手机号或密码错误";
	private static final String USER_PERMISSION_ERROR = "用户权限错误";

	private static volatile UserService instance = null;
	
	private UserService() {}

	public static UserService getInstance() {
		if(instance == null) {
			synchronized(UserService.class) {
				if(instance == null) {
					instance = new UserService();
				}
			}
		}
		return instance;
	}

	/**
	 * 用户注册业务逻辑处理,往user表中添加数据
	 * 先判断是否存在改userId,如果有直接返回注册失败的页面
	 * 否则往表中添加数据,并返回注册成功页面的路径
	 * @param user user对象
	 * @param errorList 存放错误信息
	 * @return 返回要访问的路径
	 */
	public String signIn(User user, List<String> errorList) {
		SqlSession session = MyBatisUtil.getSqlSession();
		UserDao userDao = session.getMapper(UserDao.class);
		if(userDao.hasId(user) != 0) {
			errorList.add(PHONE_NUMBER_HAS_BEEN_REGISTERED);
			MyBatisUtil.closeSession(session);
			return UserPathConstants.SIGN_IN_FAILURE_PAGE;
		}
		userDao.addData(user);
		MyBatisUtil.closeSession(session);
		return UserPathConstants.SIGN_IN_SUCCESS_PAGE;
	}


	/**
	 * 用户登录业务逻辑处理类
	 * @param user 用户对象
	 * @param errorList 错误信息集合
	 * @param roleId 角色id
	 * @return 返回要访问的路径
	 */
	public String login(User user, List<String> errorList, int roleId){
		SqlSession session = null;
		try{
			session = MyBatisUtil.getSqlSession();
			UserDao userDao = session.getMapper(UserDao.class);
			//查看用户手机号和密码是否正确
			Integer userId = userDao.loginIn(user);
			if(userId == null){
				errorList.add(LOGIN_ID_OR_PASSWORD_ERROR);
				return UserPathConstants.LOGIN_JSP_PATH;
			}
			user.setUserId(userId);
			//判断用户权限是否正确
			if(userDao.hasRole(user.getUserId(),roleId) == 0){
				//用户权限错误，存入错误，返回login.jsp页面
				errorList.add(USER_PERMISSION_ERROR);
				return UserPathConstants.LOGIN_JSP_PATH;
			}
			//一切流程正常，判断用户角色
			if(roleId == RoleConstants.ROLE_USER) {
				return UserPathConstants.USER_INDEX_JSP_PATH;
			}
			// 店家
			if(roleId == RoleConstants.ROLE_STORE) {
				return StorePathConstants.STORE_INDEX_JSP;
			}
			// 管理员
			if(roleId == RoleConstants.ROLE_ADMIN) {
				return AdminPathConstants.ADMIN_INDEX_JSP;
			}
			return null;
		} finally {
			MyBatisUtil.closeSession(session);
		}
	}

    /**
     * 查找用户的信息,并放入传入的user对象
     * @param user 含有(userId)
     * @return 将要访问的路径
     */
	public String findMyManage(User user) {
	    SqlSession session = null;
	    try {
	        session = MyBatisUtil.getSqlSession();
	        UserDao userDao = session.getMapper(UserDao.class);
	        User tempUser =  userDao.findMyManageByUserId(user.getUserId());
	        // 将获取得到的数据装入传入的user中
	        user.setUserEmail(tempUser.getUserEmail());
	        user.setUserHeadportrait(tempUser.getUserHeadportrait());
	        user.setUserNickname(tempUser.getUserNickname());
	        return UserPathConstants.USER_MANAGE_JSP_PATH;
        } finally {
	        MyBatisUtil.closeSession(session);
        }
    }


    /**
     * 更新用户头像
     * @param user 含有数据(userHeadportrait,userId)
     * @return 更新成功返回true,否则返回false
     */
    public boolean updateUserHeadImage(User user) {
	    SqlSession session = null;
	    try {
	        session = MyBatisUtil.getSqlSession();
	        UserDao userDao = session.getMapper(UserDao.class);
            int result = userDao.updateHeadImage(user);
            if(result != 0) {
                return true;
            }
            return false;
        } finally {
	        MyBatisUtil.closeSession(session);
        }
    }

    /**
     * 更新用户头像
     * @param user 数据包含(userNickname,userEmail,userId)
     * @return 更新成功返回true,否则返回false
     */
    public boolean updateMyManage(User user) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSqlSession();
            UserDao userDao = session.getMapper(UserDao.class);
            int result = userDao.updateMyManage(user);
            if(result != 0) {
                return true;
            }
            return false;
        } finally {
            MyBatisUtil.closeSession(session);
        }
    }


}
