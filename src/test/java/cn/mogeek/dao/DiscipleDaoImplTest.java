package cn.mogeek.dao;

import cn.mogeek.domain.Disciple;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import cn.mogeek.testJDBC.JDBCUtil;

public class DiscipleDaoImplTest {

    @Test
    public void testDiscipleDaoImpl(){
        DiscipleDao discipleDao = new DiscipleDaoImpl();
        List<Disciple> disciples = discipleDao.query();

        for (Disciple disciple : disciples) {
            System.out.println(disciple.toString());
        }
    }

    @Test
    public void testSave(){
        Disciple disciple = new Disciple();
        disciple.setQq(66777);
        disciple.setObject("后端工程师");
        disciple.setName("暗灭-test");
        disciple.setComefrom("大明湖畔");
        disciple.setDaily_report("https://www.zhihu.com/people/ptteng/activities");
        disciple.setBrother("不知道");
        disciple.setAims("帅就完事了");
        disciple.setGraduated_school("郑州大学");
        DiscipleDaoImpl discipleDao = new DiscipleDaoImpl();
        for (int i = 1; i <= 1000000; i ++){
            discipleDao.save(disciple);
        }
    }

    @Test
    public void testSelectById(){
        DiscipleDaoImpl discipleDao = new DiscipleDaoImpl();
        for (int i = 1; i <= 1000000; i ++){
            //System.out.println(discipleDao.slelectById(i));
            discipleDao.slelectById(i);
            System.out.println(i);
        }
    }

    @After
    public void closeCollection(){
        JDBCUtil.release();
    }
}
