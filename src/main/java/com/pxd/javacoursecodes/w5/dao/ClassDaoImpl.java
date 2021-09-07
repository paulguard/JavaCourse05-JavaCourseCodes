package com.pxd.javacoursecodes.w5.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.pxd.javacoursecodes.w5.constants.Constants;
import com.pxd.javacoursecodes.w5.entity.Clazz;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ClassDaoImpl implements ClassDao {

    @Override
    public List<Clazz> getAll() {
        System.out.println("select all class!");
        return new ArrayList<>();
    }

    @Override
    public int addClass(Clazz cls) {

        return 0;
    }

    @Override
    public int deleteClass(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result;

        try {
            Class.forName(Constants.DB_DRIVER_NAME);

            connection = DriverManager.getConnection(Constants.DB_LINK_STRING, Constants.DB_USER, Constants.DB_PASSWD);

            // 避免自动提交事务，改为后面的commit手动提交
            connection.setAutoCommit(false);

            String sql = "delete from clazz where id = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, 1);

            result = preparedStatement.executeUpdate();

            connection.commit();

            return result;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResource(connection,preparedStatement,null);
        }

        return 0;
    }

    @Override
    public int updateClass(Clazz cls) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        HikariDataSource ds = null;
        int result;

        try {
            HikariConfig config = new HikariConfig(this.getClass().getClassLoader().getResource("hikari.properties").getPath());
            ds = new HikariDataSource(config);

            connection = ds.getConnection();

            // 避免自动提交事务，改为后面的commit手动提交
            connection.setAutoCommit(false);

            String sql = "update clazz set name = ? where id = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,cls.getName());
            preparedStatement.setLong(2, cls.getId());

            result = preparedStatement.executeUpdate();

            //提交事务
            connection.commit();

            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResource(connection,preparedStatement,null);
            ds.close();
        }

        return 0;
    }

    @Override
    public List<Clazz> getClass(Long id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(Constants.DB_DRIVER_NAME);

            connection = DriverManager.getConnection(Constants.DB_LINK_STRING, Constants.DB_USER, Constants.DB_PASSWD);

            String sql = "select * from clazz where id = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, 1);

            resultSet = preparedStatement.executeQuery();

            List<Clazz> result = new ArrayList<>();
            while (resultSet.next()){

                Long idLong = resultSet.getLong("id");
                String nameString = resultSet.getString("name");

                System.out.println( idLong + " " + nameString);

                Clazz clazz = new Clazz();
                clazz.setId(idLong);
                clazz.setName(nameString);

                result.add(clazz);

            }

            return result;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {

            closeResource(connection, preparedStatement, resultSet);
        }

        return new ArrayList<>();
    }

    private void closeResource(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {

        if (Objects.nonNull(resultSet)) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
