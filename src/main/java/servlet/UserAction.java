package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;
import util.SqlSessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.SecureRandom;
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
            check(req, resp);
        }
    }

    private void check(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(false);
        User user = sqlSession.selectOne("user.check", new User(null, req.getParameter("username"), null, null));
        sqlSession.close();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Boolean> map = new HashMap<>();
        if (user != null) {
            map.put("user exist", true);
        } else {
            map.put("user no exist", false);
        }
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().print(objectMapper.writeValueAsString(map));
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();
        resp.sendRedirect("default.jsp");

    }

    private String getSaltbyusername(String username) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(false);
        User user = sqlSession.selectOne("user.searchUserByUsername",new User(null,username,null,null));
        sqlSession.close();
        return user.getSalt();
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(false);
        //String salt = getSaltbyusername(req.getParameter("username"));
       // String password=DigestUtils.sha256Hex(req.getParameter("password").concat(salt));
        User user = sqlSession.selectOne("user.login",new User(null,req.getParameter("username"),req.getParameter("password"),null));
        sqlSession.close();
        if (user != null) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("word?cation=query");
        } else {
            req.getSession().setAttribute("message", "错误");
            req.getRequestDispatcher("default.jsp").forward(req, resp);
        }

    }
//    private String getSalt() {
//        SecureRandom SRandom = new SecureRandom();
//        byte[] bytes = new byte[64];
//        SRandom.nextBytes(bytes);
//        return new String(bytes);}

    private void signup(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        //String salt=getSalt();
        //String password= DigestUtils.sha256Hex(req.getParameter("password").concat(salt));
        User user = sqlSession.selectOne("user.signup", new User(null, req.getParameter("username"),req.getParameter("password"),null));
        sqlSession.close();
        resp.sendRedirect("default.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }
}
