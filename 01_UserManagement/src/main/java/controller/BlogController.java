package controller;

import dao.BlogDAO;
import dao.UserDAO;
import model.Blog;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BlogController", urlPatterns = "/blogs")
public class BlogController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BlogDAO blogDAO;

    public void init() {
        blogDAO = new BlogDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("blog/list.jsp");
        List<Blog> list=blogDAO.findAll();
        request.setAttribute("listBlog",list);
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
