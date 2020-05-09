package cn.mogeek.dao;

import cn.mogeek.domain.Disciple;
import cn.mogeek.testJDBC.JDBCUtil;

import java.sql.Connection;
import java.util.List;

/**
 * DiscipleDao 访问接口
 */
public interface DiscipleDao {

    static Connection connection = JDBCUtil.getConnection();

    /**
     * 查询所有报名的弟子
     * @return 返回一个弟子信息的list
     */
    public List<Disciple> query();

    /**
     * 保存一个新弟子
     * @param disciple 弟子对象
     */
    public void save(Disciple disciple);

    public Disciple slelectById(int id);


}
