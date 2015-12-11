package servlet;

import model.Word;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/word")
public class WordAction extends HttpServlet {
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
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
        String SQL = "DELETE  FROM word WHERE id=?";
        try {
            preparedStatement = DB.getConnection().prepareStatement(SQL);
            preparedStatement.setInt(1, Integer.parseInt(req.getParameter("id")));
            resp.sendRedirect("word?action=query");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String SQL = "UPDATE word SET english=?,chinese=? WHERE id=?";
        try {
            preparedStatement = DB.getConnection().prepareStatement(SQL);
            preparedStatement.setString(1, req.getParameter("english"));
            preparedStatement.setString(2, req.getParameter("chinese"));
            preparedStatement.setInt(3, Integer.parseInt(req.getParameter("id")));
            preparedStatement.executeUpdate();
            resp.sendRedirect("word?action=query");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String SQL = "select * from word;WHERE id=?";
        try {
            preparedStatement = DB.getConnection().prepareStatement(SQL);
            preparedStatement.setInt(1, Integer.parseInt(req.getParameter("id")));
            resultSet = preparedStatement.executeQuery();
            Word word = null;
            if (resultSet.next()) {
                word = new Word(resultSet.getInt("id"), resultSet.getString("english"), resultSet.getString("chinese"));
                req.getSession().setAttribute("word", word);
                resp.sendRedirect("edit.jsp");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(resultSet,preparedStatement);
        }

    }

    private void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String SQL = "select * from word";
        try {
            preparedStatement = DB.getConnection().prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            List<Word> words = new ArrayList<>();
            while (resultSet.next()) {
               Word word = new Word(resultSet.getInt("id"), resultSet.getString("english"), resultSet.getString("chinese"));
                words.add(word);
            }
            req.getSession().setAttribute("words", words);
            resp.sendRedirect("index.jsp");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.close(null, preparedStatement);
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String SQL = "INSERT  INTO word VALUES (NULL ,?,?)";
        try {
            preparedStatement = DB.getConnection().prepareStatement(SQL);
            preparedStatement.setString(1, req.getParameter("english"));
            preparedStatement.setString(2, req.getParameter("chinese"));
            preparedStatement.executeUpdate();
            resp.sendRedirect("Word?action=query");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.close(null, preparedStatement);
        }

    }
}
