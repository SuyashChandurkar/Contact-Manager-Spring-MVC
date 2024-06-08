<%@page import="com.jspiders.springmvc.dto.ContactDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
<%ContactDto contact=(ContactDto)request.getAttribute("contact"); %>s
<div class="form-container">
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
        <form action="updatecontact" method="post" >
            <h2>update Contact here</h2>
            <label for="id">Id:</label>
            <input type="text" id="id" name="id" readonly="readonly" value="<%=contact.getId()%>">
            
            <label for="firstname">First Name:</label>
            <input type="text" id="firstname" name="firstname" value="<%=contact.getFirstname() %>">

            <label for="lastname">Last Name:</label>
            <input type="text" id="lastname" name="lastname" value="<%=contact.getLastname() %>" >

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="<%=contact.getEmail()%>">

            <label for="mobile">Mobile Number:</label>
            <input type="tel" id="mobile" name="mobile" value="<%= contact.getPhonebumber()%>">

            <button type="submit" value="submit" class="btn-grad">Save</button>
        </form>
        
    </div>
</body>
</body>
</html>