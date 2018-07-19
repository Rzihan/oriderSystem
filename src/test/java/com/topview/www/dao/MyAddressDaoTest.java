package com.topview.www.dao;

import com.topview.www.po.MyAddress;
import com.topview.www.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyAddressDaoTest {

    @Test
    public void findMyAddressById() {
    }

    @Test
    public void testUpdateData() {
        SqlSession session = null;
        session = MyBatisUtil.getSqlSession();
        MyAddressDao myAddressDao = session.getMapper(MyAddressDao.class);
        MyAddress myAddress = new MyAddress();
        myAddress.setId(41);
        myAddress.setPhone("15521055460");
        myAddress.setLinkman("鬼啊");
        myAddress.setAddress("guangdong");
        int result = myAddressDao.updateData(myAddress);
        MyBatisUtil.closeSession(session);
        assertEquals(1, result);
    }



}