package cn.www.web.servlet;

import cn.www.domain.PageBean;
import cn.www.domain.User;
import cn.www.service.UserService;
import cn.www.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author Ling
 * Created on 2020/2/1
 */
@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String _currentPage = request.getParameter("currentPage");
        String _rows = request.getParameter("rows");
        UserService userService = new UserServiceImpl();
        int currentPage = "".equals(_currentPage) || _currentPage == null ? 1 : Integer.parseInt(_currentPage);
        int rows = "".equals(_rows) || _rows == null ? 5 : Integer.parseInt(_rows);
        Map<String, String[]> map = request.getParameterMap();
        PageBean<User> pageBean = userService.findUserByPage(currentPage, rows, map);
        request.setAttribute("pageBean", pageBean);
        request.setAttribute("condition",map);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
