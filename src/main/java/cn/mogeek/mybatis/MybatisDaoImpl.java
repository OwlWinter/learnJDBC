package cn.mogeek.mybatis;

import cn.mogeek.domain.Disciple;
import java.util.List;

public class MybatisDaoImpl implements MybatisDao {
    public Disciple selectById(int id){
        Disciple disciple = sqlsession.selectOne("mapper.discipleMapper.getDisciple", id);
        return disciple;
    }

    public int insert(Disciple disciple){
        sqlsession.insert("mapper.discipleMapper.insertDisciple", disciple);
        sqlsession.commit();
        return disciple.getId();
    }

    public void deleteById(int id){
        sqlsession.delete("mapper.discipleMapper.deleteDisciple", id);
        sqlsession.commit();
        sqlsession.clearCache();
    }

    @Override
    public List<Disciple> selectAll(){
        List<Disciple> discipleList = sqlsession.selectList("mapper.discipleMapper.selectAllDisciples");
        return discipleList;
    }

    public void update(Disciple disciple){
        sqlsession.update("mapper.discipleMapper.updateDisciple", disciple);
        sqlsession.commit();
        sqlsession.clearCache();
    }

    public void closeSqlsession(){
        sqlsession.close();
    }
}
