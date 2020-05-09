package cn.mogeek.dao;

import cn.mogeek.domain.Disciple;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiscipleDaoSpringJdbcImpl implements DiscipleDao {

    private JdbcTemplate jdbcTemplate = null;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Disciple> query() {
        final List<Disciple> discipleList = new ArrayList<Disciple>();
        String sql = "select * from jnshu_copy1";

        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                int id = rs.getInt("id");
                int qq = rs.getInt("qq");
                String name = rs.getString("name");
                String object = rs.getString("object");
                String graduated_school = rs.getString("graduated_school");
                String brother = rs.getString("brother");
                String from = rs.getString("comefrom");
                String daily_report = rs.getString("daily_report");
                String aims = rs.getString("aims");

                Disciple disciple = new Disciple();
                disciple.setAims(aims);
                disciple.setId(id);
                disciple.setBrother(brother);
                disciple.setDaily_report(daily_report);
                disciple.setComefrom(from);
                disciple.setName(name);
                disciple.setObject(object);
                disciple.setQq(qq);

                discipleList.add(disciple);
            }
        });
        return discipleList;
    }

    @Override
    public void save(Disciple disciple) {
        String sql = "insert into " +
                "jnshu_copy1(id, qq, name, object, graduated_school, brother, comefrom, daily_report, aims) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, new Object[]{disciple.getId(), disciple.getQq(), disciple.getName(),
                disciple.getObject(), disciple.getGraduated_school(), disciple.getBrother(), disciple.getComefrom(),
                disciple.getDaily_report(), disciple.getAims()});
    }

    public Disciple slelectById(int id){
        String sql = "select * from jnshu_copy1 where id = ?";
        RowMapper<Disciple> discipleDaoRowMapper = new BeanPropertyRowMapper<>(Disciple.class);
        Disciple disciple = jdbcTemplate.queryForObject(sql, discipleDaoRowMapper, id);
        return disciple;
    }
}
