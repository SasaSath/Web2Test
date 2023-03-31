<%@ page import="java.sql.Connection" %>
<%@ page import="lk.apexrow.web.db.DBConnection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: INSIGHT
  Date: 3/31/2023
  Time: 11:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
</head>

<body>

<h1>Hello</h1>

<h4>Enter Details</h4>

<form action="logintest" method="POST">

    <span>Mobile</span>
    <input type="text" name="mobile">

    <br/><br/>

    <span>Name</span>
    <input type="text" name="name">

    <br/><br/>

    <span>Password</span>
    <input type="password" name="password">

    <br/><br/>

    <span>City</span>
    <input type="text" name="city">

    <br/><br/>

    <input type="submit" value="Submit">

</form>

<br/><br/>

<h4>Registered Users</h4>

<table>

    <tr>
        <th> ID</th>
        <th> Mobile</th>
        <th> Name</th>
        <th> Password</th>
        <th> City</th>
    </tr>

    <%

        Connection connection = null;

        try {

            connection = DBConnection.getConnection();

            ResultSet result = DBConnection.search("SELECT * FROM `user`");

            while (result.next()) {
    %>
    <tr>
        <td>
            <%= result.getString("id") %>
        </td>
        <td>
            <%= result.getString("mobile") %>
        </td>
        <td>
            <%= result.getString("name") %>
        </td>
        <td>
            <%= result.getString("password") %>
        </td>
        <td>
            <%= result.getString("city") %>
        </td>
    </tr>
    <%
            }

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

    %>

</table>

</body>
</html>
