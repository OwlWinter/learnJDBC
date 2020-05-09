package cn.mogeek.mybatis;

import cn.mogeek.domain.Disciple;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MybatisTest{

    MybatisDaoImpl mybatisDaoimpl = new MybatisDaoImpl();

    @Test
    public void testSelectById(){
        Disciple disciple = mybatisDaoimpl.selectById(1);
        Assert.assertNotNull(disciple);
        System.out.println(disciple.toString());
        mybatisDaoimpl.closeSqlsession();
    }

    @Test
    public void testInsert(){
        Disciple disciple = new Disciple();
        disciple.setQq(788857);
        disciple.setObject("无限奥义循环");
        disciple.setName("奇异博士");
        disciple.setComefrom("英国");
        disciple.setDaily_report("https://baike.baidu.com/item/%E5%A5%87%E5%BC%82%E5%8D%9A%E5%A3%AB/2492942");
        disciple.setBrother("古一法师");
        disciple.setAims("打败多玛姆");
        disciple.setGraduated_school("格林威治村");
        for (int i = 10000; i > 0; i--)
            mybatisDaoimpl.insert(disciple);
        System.out.println(disciple.toString());
        mybatisDaoimpl.closeSqlsession();
    }

    @Test
    public void testSelectAll(){
        List<Disciple> discipleList = mybatisDaoimpl.selectAll();
        if (!discipleList.isEmpty()){
            for (Disciple disciple:discipleList
                 ) {
                System.out.println(disciple.toString());
            }
        }
        System.out.println("元素数：" + discipleList.size());
        mybatisDaoimpl.closeSqlsession();
    }

    @Test
    public void testDelete(){
        mybatisDaoimpl.deleteById(2);
        testSelectAll();
        mybatisDaoimpl.closeSqlsession();
    }

    @Test
    public void testUpdate(){
        Disciple disciple = new Disciple();
        int id = 1;
        disciple.setId(id);
        disciple.setName("李四");
        disciple.setComefrom("China");
        disciple.setObject("前端工程师");
        mybatisDaoimpl.update(disciple);
        System.out.println(mybatisDaoimpl.selectById(id).toString());
        mybatisDaoimpl.closeSqlsession();
    }

}
