package dao;

import model.Blog;

import java.sql.SQLException;
import java.util.List;

public interface IBlogDAO {
    public void insert(Blog blog) throws SQLException;

    public Blog select(int id);

    public List<Blog> findAll();

    public boolean delete(int id) throws SQLException;

    public boolean update(Blog blog) throws SQLException;

    public List<Blog> orderByName();

    public List<Blog> selectUserByCountry(String nation);
}
