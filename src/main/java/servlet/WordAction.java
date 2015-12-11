package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/word")
public class WordAction extends HttpServlet {
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

}
