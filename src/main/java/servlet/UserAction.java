package servlet;

import util.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/user")
public class UserAction extends HttpServlet {
    private static final String sign_up_sql = "INSERT INTO user VALUES (NULL ,?,?)";
    private static final String login_sql = "SELECT * FROM user WHERE user=? AND password=?";

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
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().invalidate();
        try {
            resp.sendRedirect("default.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = DB.getConnection().prepareStatement(login_sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                req.getSession().setAttribute("username", username);
                resp.sendRedirect("word?action=query");
            } else {
                req.setAttribute("message", "用户名或密码错误！");
                resp.sendRedirect("default.jsp");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.close(resultSet, preparedStatement);
        }

    }

    private void signup(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        PreparedStatement prepare = null;
        try {
            prepare = DB.getConnection().prepareStatement(sign_up_sql)
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.close(null, prepare);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);
    }
}
