<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Search</title>
<style>
    
    body {
        font-family: Arial, sans-serif;
        background-color: #ffffcc; /* Lemon yellow background */
        margin: 0;
        padding: 0;
    }
    form {
        margin: 20px auto;
        width: 50%;
        padding: 20px;
        border: 1px solid #ccc;
        background-color: #cceeff; /* Light blue background */
        border-radius: 8px; /* Rounded corners */
    }
    label {
        display: block;
        margin-bottom: 10px;
        font-weight: bold;
        color: #005faa; /* Dark blue color */
    }
    select, input[type="text"] {
        width: 100%;
        padding: 10px;
        font-size: 16px;
        border: 1px solid #ccc;
        border-radius: 4px; /* Rounded corners */
        box-sizing: border-box;
        margin-bottom: 10px;
    }
    input[type="submit"] {
        padding: 10px 20px;
        font-size: 16px;
        border: none;
        border-radius: 4px; /* Rounded corners */
        background-color: #005faa; /* Dark blue background */
        color: white;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #003366; /* Darker blue on hover */
    }

</style>
</head>
<body>
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
  
  
  
  
  
<div align="center"><h1>Search By Contacts Using Option </h1></div>



<form action="searchbyoperation" method="post">
    <label for="search_criteria">Search by:</label>
    <select id="search_criteria" name="option">
        <option  value="id">ID</option>
        <option  value="email">Email</option>
        <option  value="firstname">First Name</option>
        <option  value="lastname">Last Name</option>
        <option  value="phone">Phone Number</option>
    </select>

    <label for="search_term">Search Term:</label>
    <input type="text" id="search_term" name="name" placeholder="Enter Search Term">
    
    <input type="submit" value="Search">
</form>



</body>
</html>
