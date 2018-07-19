package com.topview.www.dao;

import com.topview.www.po.Evaluation;
import com.topview.www.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class EvaluationDaoTest {

    @Test
    public void testAddData() {
        Evaluation evaluation = new Evaluation();
        evaluation.setFoodId(8);
        evaluation.setUserId(25);
        evaluation.setStoreId(9);
        evaluation.setFoodEvaluation("测试");
        SqlSession session = MyBatisUtil.getSqlSession();
        EvaluationDao evaluationDao = session.getMapper(EvaluationDao.class);
        int result = evaluationDao.addData(evaluation);
        MyBatisUtil.closeSession(session);
    }

}