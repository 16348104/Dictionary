package servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import org.apache.ibatis.session.SqlSession;
import util.DB;
import util.SqlSessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user")
public class UserAction extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("signup")) {
            signup(req, resp);
        }
        if (action.equals("login")) {
            login(req, resp);
        }
        if (action.equals("logout")) {
            logout(req, resp);
        }
        if (action.equals("check")) {
            check(req,resp);
        }
    }

    private void check(HttpServletRequest req, HttpServletResponse resp) throws IOException

    {
//        String username = req.getParameter("username");
//        System.out.println(username);
//        String sql = "select * from user where username=?";
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        ObjectMapper objectMapper = new ObjectMapper();
        SqlSession sqlSession =  SqlSessionUtil.getSqlSession(false);
        User user =sqlSession.selectOne("user.check",new User(null,req.getParameter("username"),null));
        sqlSession.close();
        Map<String, Boolean> map = new HashMap<>();
        try {
            preparedStatement = DB.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                map.put("isUsernameExist", true);
            } else {
                map.put("isUsernameExist", false);
            }
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().print(objectMapper.writeValueAsString(map)); // {"isUsernameExist":true/false}
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.close(resultSet, preparedStatement);
        }
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();
        resp.sendRedirect("default.jsp");

    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        User user = sqlSession.selectOne("user.login", new User(null, req.getParameter("username"), req.getParameter("password")));
        sqlSession.close();
        if (user!=null) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("word?cation=query");
        } else {
            req.getSession().setAttribute("message","错误");
            req.getRequestDispatcher("default.jsp").forward(req,resp);
        }

    }
    private void signup(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        User user = sqlSession.selectOne("user.login", new User(null, req.getParameter("username"), req.getParameter("password")));
        sqlSession.commit();
        sqlSession.close();
        resp.sendRedirect("default.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }
}
