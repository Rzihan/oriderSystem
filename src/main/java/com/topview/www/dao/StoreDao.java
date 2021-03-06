package com.topview.www.dao;

import com.topview.www.po.Store;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreDao extends BaseDao<Store>{

    Store getStoreByUserId(int userId);

    int updateApplyForState(Store store);

    int addUserAndRoleData(@Param("userId") int userId, @Param("roleId")int roleId);

    int deleteUserAndRoleData(@Param("userId") int userId, @Param("roleId")int roleId);

    List<Store> findAllApplyForStore();

    int getUserSearchStoresAllTotal(@Param("applyForState")int applyForState, @Param("search")String search);

    List<Store> getUserSearchStores(@Param("applyForState")int applyForState, @Param("search")String search,
                                    @Param("startRow")int startRow, @Param("pageSize")int pageSize);
}
