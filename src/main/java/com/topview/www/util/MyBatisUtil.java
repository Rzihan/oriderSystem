package com.topview.www.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisUtil {

    private static final String MYBATIS_CONF_PATH = "/conf.xml";

    private static SqlSessionFactory sqlSessionFactory;

    static {
        // 加载MyBatis的配置文件
        InputStream is = MyBatisUtil.class.getResourceAsStream(MYBATIS_CONF_PATH);
        // 构建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    public static void closeSession(SqlSession sqlSession) {
        if(sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
