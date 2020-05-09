package cn.mogeek.dao;

import cn.mogeek.domain.Disciple;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.List;

public class DiscipleDaoSpringJDBCImplTest {

    private ApplicationContext ctx = null;
    private DiscipleDao discipleSpringDao = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        discipleSpringDao = (DiscipleDao)ctx.getBean("discipleDAO");
    }

    @After
    public void teardown(){
        ctx = null;
    }

    @Test
    public void testDiscipleDaoSpringJDBCImpl(){
        List<Disciple> disciples = discipleSpringDao.query();

        for (Disciple disciple : disciples) {
            System.out.println("id: " + disciple.getId()
                    + ", name: " + disciple.getName()
                    + ", object: " + disciple.getObject()
                    + ", aims: " + disciple.getAims()
                    + ", qq: " + disciple.getQq()
                    + ", brother: " + disciple.getBrother()
                    + ", from: " + disciple.getComefrom()
                    + ", daily_report: " + disciple.getDaily_report()
                    + ", graduated_school: " + disciple.getGraduated_school()
            );
        }
    }

    @Test
    public void testSave(){
        Disciple disciple = new Disciple();
        disciple.setQq(666666);
        disciple.setObject("后端工程师");
        disciple.setName("暗灭-SpringTest");
        disciple.setComefrom("大明湖畔");
        disciple.setDaily_report("https://www.zhihu.com/people/ptteng/activities");
        disciple.setBrother("不知道");
        disciple.setAims("帅就完事了");
        disciple.setGraduated_school("郑州大学");
        discipleSpringDao.save(disciple);
    }

    @Test
    public void testQueryById(){
        for (int i = 1; i <= 10000; i ++){
           discipleSpringDao.slelectById(i);
            //System.out.println(discipleSpringDao.slelectById(i));
            System.out.println(i);
        }
    }
}
