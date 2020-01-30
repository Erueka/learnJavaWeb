package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Ling
 * Created on 2020/1/30
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、设置编码
        request.setCharacterEncoding("utf-8");
        // 2、 获取数据
        String verifycode = request.getParameter("verifycode");
        Map<String, String[]> map = request.getParameterMap();
        // 3、 封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 3.2 验证码校验
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if (!checkcode_server.equalsIgnoreCase(verifycode)) {
            // 验证码不正确
            request.setAttribute("login_msg", "验证码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        // 4、 用Service查询
        UserServiceImpl userService = new UserServiceImpl();
        User loginUser = userService.login(user);
        // 5、 判断
        if (loginUser != null) {
            // 登陆成功
            session.setAttribute("user",loginUser);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            // 登陆失败
            request.setAttribute("login_msg", "用户名或密码！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
