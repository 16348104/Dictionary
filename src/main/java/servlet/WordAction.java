package servlet;

import model.Word;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisSqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/word")
public class WordAction extends HttpServlet {

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
        SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlsession(true);
        sqlSession.delete("word.delete", getWord(req));
        sqlSession.close();
        resp.sendRedirect("word?action=query");
    }


    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlsession(true);
        sqlSession.update("word.update", getWord(req));
        sqlSession.close();
        resp.sendRedirect("word?action=query");
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SqlSession sqlSession =MyBatisSqlSessionFactory.getSqlsession(false);
        req.getSession().setAttribute("word", sqlSession.selectOne("word.search", getWord(req)));
        sqlSession.close();
        resp.sendRedirect("edit.jsp");
    }

    private void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlsession(false);
        req.getSession().setAttribute("word", sqlSession.selectList("word.query"));
        sqlSession.close();
        resp.sendRedirect("index.jsp");
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlsession(true);
        sqlSession.insert("word.add", getWord(req));
        sqlSession.close();
        resp.sendRedirect("word?action=query");

    }
    private Word getWord(HttpServletRequest req) {
        Integer id = null;
        if (req.getParameter("id") != null) {
            id = Integer.parseInt(req.getParameter("id"));
        }
        return new Word(id, req.getParameter("english"), req.getParameter("chinese"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
