<%@ page import="com.jspiders.springmvc.dto.ContactDto" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact List</title>
<style>
      body {
        font-family: 'Arial', sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f9;
        color: #333;
    }
    .container {
        width: 90%;
        max-width: 1200px;
        margin: 20px auto;
        padding: 20px;
        background-color: #ffd166; /* Yellow background */
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
        background-color: #fff; /* White background */
    }
    th, td {
        padding: 12px 15px;
        text-align: left;
        border: 1px solid #ddd;
        font-size: 16px;
    }
    th {
        background-color: #0077cc; /* Blue background */
        color: white;
        text-transform: uppercase;
    }
    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
    tr:hover {
        background-color: #f1f1f1;
    }
    h3 {
        color: #0077cc; /* Blue color */
    }
    form {
        margin-top: 20px;
        display: flex;
        justify-content: center;
        gap: 10px;
    }
    form input[type="text"] {
        padding: 10px;
        font-size: 16px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    form input[type="submit"] {
        padding: 10px 20px;
        font-size: 16px;
        border: none;
        border-radius: 4px;
        background-color: #0077cc; /* Blue background */
        color: white;
        cursor: pointer;
    }
    form input[type="submit"]:hover {
        background-color: #005faa; /* Darker blue on hover */
    }
    a {
        text-decoration: none;
        color: #0077cc; /* Blue color */
        font-weight: bold;
    }
    a:hover {
        color: #005faa; /* Darker blue on hover */
    }
    @media (max-width: 768px) {
        table, th, td {
            font-size: 14px;
        }
        form input[type="text"], form input[type="submit"] {
            width: 100%;
            box-sizing: border-box;
            margin: 5px 0;
        }
        form {
            flex-direction: column;
        }
    }
</style>
</head>
<body>

<div class="container">
<div align="center">
    <a href="home" style="
      display: inline-block;
      padding: 10px 20px;
      font-size: 16px;
      color: white;
      background-color: blue;
      text-align: center;
      text-decoration: none;
      border-radius: 5px;
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
     ">
      Back To HomePage
    </a>
  </div>
    <%
        List<ContactDto> contacts = (List<ContactDto>) request.getAttribute("contacts");
        if (contacts != null) {
    %>
    
    <form action="update" method="post">
    <input type="text" name="id" required="required"><input type="submit" value="Edit">
    </form>
        <table>
            <tr>
                <th>ID</th>
                <th>FIRST NAME</th>
                <th>LAST NAME</th>
                <th>EMAIL</th>
                <th>MOBILE</th>
            </tr>
            <%
                for (ContactDto contact : contacts) {
            %>
            <tr>
                <td><%= contact.getId() %></td>
                <td><%= contact.getFirstname() %></td>
                <td><%= contact.getLastname() %></td>
                <td><%= contact.getEmail() %></td>
                <td><%= contact.getPhonebumber() %></td>
            </tr>
            <%
                }
            %>
        </table>
    <%
        }
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
    <div align="center">
        <h3><%= message %></h3>
    </div>
    <%
        }
    %>
</div>
</body>
</html>
