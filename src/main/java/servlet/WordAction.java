package servlet;

import model.Word;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/word")
public class WordAction extends HttpServlet {
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("add")) {
            add(req, resp);
        }
        if (action.equals("query")) {
            query(req, resp);
        }
        if (action.equals("search")) {
            search(req, resp);
        }
        if (action.equals("update")) {
            update(req, resp);
        }
        if (action.equals("delete")) {
            delete(req, resp);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        sqlSession.delete("word.delete",getWord(req));
        sqlSession.close();
        resp.sendRedirect("word?action=query");
    }

    private Word getWord(HttpServletRequest req) {
        Integer id = null;
        if (req.getParameter("id")!=null) {
            id = Integer.parseInt(req.getParameter("id"));
        }
        return new Word(id, req.getParameter("english"), req.getParameter("chinese"));
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        sqlSession.update("word.update", getWord(req));
        sqlSession.close();
        resp.sendRedirect("word?action=query");
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(false);
        req.getSession().setAttribute("word",sqlSession.selectOne("word.search",getWord(req)));
        sqlSession.close();
        resp.sendRedirect("edit.jsp");
    }

    private void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(false);
        req.getSession().setAttribute("wrod",sqlSession.selectList("wrod.query"));
        sqlSession.close();
        resp.sendRedirect("index.jsp");
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        sqlSession.insert("word.add", getWord(req));
        sqlSession.close();
        resp.sendRedirect("word?action=query");

    }
}
