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
        background-color: #f4f4f9; /* Light grey background */
        color: #333;
    }
    .container {
        width: 90%;
        max-width: 1200px;
        margin: 20px auto;
        padding: 20px;
        background-color: #ffec80; /* Lemon yellow background */
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
        background-color: #f9f9f9; /* Light grey background for even rows */
    }
    tr:hover {
        background-color: #f1f1f1; /* Light grey background on hover */
    }
    h3 {
        color: #0077cc; /* Blue color for message */
    }
    a {
        text-decoration: none;
        color: #0077cc; /* Blue color for links */
        font-weight: bold;
    }
    a:hover {
        color: #005faa; /* Darker blue on hover */
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
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
    <div align="center">
        <h3 style="background-color: red; color: white;"><%= message %></h3>
    </div>
    <%
        }
    %>




    <%
        List<ContactDto> contacts = (List<ContactDto>) request.getAttribute("contacts");
        if (contacts != null) {
    %>
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
        }%>
        
        
      
</div>
</body>
</html>
