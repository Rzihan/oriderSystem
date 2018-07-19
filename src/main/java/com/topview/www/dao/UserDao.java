package com.topview.www.dao;

import com.topview.www.po.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao extends BaseDao<User>{

    int hasId(User user);

    int hasRole(@Param("userId")int userId, @Param("roleId")int roleId);

    int updateHeadImage(User user);

    int updateMyManage(User user);

    Integer loginIn(User user);

    User findMyManageByUserId(int userId);
}
