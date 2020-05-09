package cn.mogeek.dao;

import cn.mogeek.domain.Disciple;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiscipleDaoImpl implements DiscipleDao {

    @Override
    public List<Disciple> query() {

        List<Disciple> disciples = new ArrayList<Disciple>();
        Disciple disciple;

        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String sql = "select * from jnshu_copy1";

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                int id = resultSet.getInt("id");
                int qq = resultSet.getInt("qq");
                String name = resultSet.getString("name");
                String object = resultSet.getString("object");
                String graduated_school = resultSet.getString("graduated_school");
                String brother = resultSet.getString("brother");
                String from = resultSet.getString("comefrom");
                String daily_report = resultSet.getString("daily_report");
                String aims = resultSet.getString("aims");

                disciple = new Disciple();
                disciple.setAims(aims);
                disciple.setId(id);
                disciple.setBrother(brother);
                disciple.setDaily_report(daily_report);
                disciple.setComefrom(from);
                disciple.setName(name);
                disciple.setObject(object);
                disciple.setQq(qq);

                disciples.add(disciple);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                }catch (SQLException e){
                    System.out.println(e);
                }
            }

            if (resultSet != null){
                try {
                    preparedStatement.close();
                }catch (SQLException e){
                    System.out.println(e);
                }
            }
        }
        return disciples;
    }

    @Override
    public void save(Disciple disciple) {

        //Statement sta = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into jnshu_copy1(id, qq, name, object, graduated_school, brother, comefrom, daily_report, aims) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, disciple.getId());
            preparedStatement.setInt(2, disciple.getQq());
            preparedStatement.setString(3, disciple.getName());
            preparedStatement.setString(4, disciple.getObject());
            preparedStatement.setString(5, disciple.getGraduated_school());
            preparedStatement.setString(6, disciple.getBrother());
            preparedStatement.setString(7, disciple.getComefrom());
            preparedStatement.setString(8, disciple.getDaily_report());
            preparedStatement.setString(9, disciple.getAims());
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                }catch (SQLException e){
                    System.out.println(e);
                }
            }

            if (resultSet != null){
                try {
                    preparedStatement.close();
                }catch (SQLException e){
                    System.out.println(e);
                }
            }
        }
    }

    @Override
    public Disciple slelectById(int _id){
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String sql = "select * from jnshu_copy1 where id = ?";

        Disciple disciple = new Disciple();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,_id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int qq = resultSet.getInt("qq");
                String name = resultSet.getString("name");
                String object = resultSet.getString("object");
                String graduated_school = resultSet.getString("graduated_school");
                String brother = resultSet.getString("brother");
                String from = resultSet.getString("comefrom");
                String daily_report = resultSet.getString("daily_report");
                String aims = resultSet.getString("aims");

                disciple.setAims(aims);
                disciple.setId(id);
                disciple.setBrother(brother);
                disciple.setDaily_report(daily_report);
                disciple.setComefrom(from);
                disciple.setName(name);
                disciple.setObject(object);
                disciple.setQq(qq);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                }catch (SQLException e){
                    System.out.println(e);
                }
            }

            if (resultSet != null){
                try {
                    preparedStatement.close();
                }catch (SQLException e){
                    System.out.println(e);
                }
            }
        }

        return disciple;
    }
}


