package dao;

import model.Blog;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogDAO implements IBlogDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/usermanagement";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    public BlogDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catsch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Blog> findAll() {
        List<Blog> blogs = new ArrayList<>();
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement("select * from blogs");) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                int user_id=rs.getInt("user_id");
                blogs.add(new Blog(id, title, content, user_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return blogs;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


    @Override
    public void insert(Blog blog) throws SQLException {

    }

    @Override
    public Blog select(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Blog blog) throws SQLException {
        return false;
    }

    @Override
    public List<Blog> orderByName() {
        return null;
    }

    @Override
    public List<Blog> selectUserByCountry(String nation) {
        return null;
    }
}
