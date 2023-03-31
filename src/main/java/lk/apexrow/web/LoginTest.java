package lk.apexrow.web;

import lk.apexrow.web.db.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "logintest", value = "/logintest")
public class LoginTest extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        String mobile = request.getParameter("mobile");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String city = request.getParameter("city");

        Connection connection = null;

        response.getWriter().write("Servlet");
        try {

            connection = DBConnection.getConnection();

            DBConnection.iud("INSERT INTO `user`(`mobile`,`name`,`password`,`city`) VALUES ('" + mobile + "','" + name + "','" + password + "','" + city + "')");

            response.sendRedirect("logintest.jsp");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
