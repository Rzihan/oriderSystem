package com.topview.www.dao;

import com.topview.www.po.MyAddress;

public interface MyAddressDao extends BaseDao<MyAddress>{

    MyAddress findMyAddressById(int id);

    int deleteMyAddress(int id);
}
