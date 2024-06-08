<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.jspiders.springmvc.dto.ContactDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Details</title>
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
        background-color: #ffec80;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
        background-color: #fff;
    }
    th, td {
        padding: 12px 15px;
        text-align: left;
        border: 1px solid #ddd;
        font-size: 16px;
    }
    th {
        background-color: #0077cc;
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
        color: #0077cc;
    }
    a {
        text-decoration: none;
        color: #0077cc;
        font-weight: bold;
    }
    a:hover {
        color: #005faa;
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
    <h2>Contact Details</h2>
    <%
        ContactDto contact = (ContactDto) request.getAttribute("contact");
        if (contact != null) {
    %>
    <table>
        <tr>
            <th>ID</th>
            <td><%= contact.getId() %></td>
        </tr>
        <tr>
            <th>First Name</th>
            <td><%= contact.getFirstname() %></td>
        </tr>
        <tr>
            <th>Last Name</th>
            <td><%= contact.getLastname() %></td>
        </tr>
        <tr>
            <th>Email</th>
            <td><%= contact.getEmail() %></td>
        </tr>
        <tr>
            <th>Mobile</th>
            <td><%= contact.getPhonebumber()%></td>
        </tr>
    </table>
    <%
        } else {
    %>
    <p>No contact details available.</p>
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
