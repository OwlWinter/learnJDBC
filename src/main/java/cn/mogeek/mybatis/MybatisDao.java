package cn.mogeek.mybatis;

import cn.mogeek.domain.Disciple;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface MybatisDao {
    static SqlSession sqlsession = DBTools.getSqlSession();

    public Disciple selectById(int id);

    public int insert(Disciple disciple);

    public void deleteById(int id);

    public List<Disciple> selectAll();

    public void update(Disciple disciple);

    public void closeSqlsession();
}
