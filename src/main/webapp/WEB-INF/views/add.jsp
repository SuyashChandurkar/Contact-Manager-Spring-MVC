<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">body {
    font-family: Arial, sans-serif;
    background-color: #f2f2f2;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}

.form-container {
    background-color: #fff;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 300px;
}

form {
    display: flex;
    flex-direction: column;
}

h2 {
    text-align: center;
    margin-bottom: 20px;
    color: #333;
}

label {
    margin-bottom: 5px;
    color: #555;
}

input {
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ddd;
    border-radius: 5px;
}

button {
    padding: 10px;
    border: none;
    border-radius: 5px;
    background-color: #5cb85c;
    color: #fff;
    font-size: 16px;
    cursor: pointer;
}

button:hover {
    background-color: #4cae4c;
}
         
         .btn-grad {
            background-image: linear-gradient(to right, #16A085 0%, #F4D03F  51%, #16A085  100%);
            margin: 10px;
            padding: 15px 45px;
            text-align: center;
            text-transform: uppercase;
            transition: 0.5s;
            background-size: 200% auto;
            color: white;            
            box-shadow: 0 0 20px #eee;
            border-radius: 10px;
            display: block;
          }

          .btn-grad:hover {
            background-position: right center; /* change the direction of the change here */
            color: #fff;
            text-decoration: none;
          }
         
</style>
</head>
<body>

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
        <form action="contact" method="post">
            <h2>Contact Form</h2>
            <label for="firstname">First Name:</label>
            <input type="text" id="firstname" name="firstname" >

            <label for="lastname">Last Name:</label>
            <input type="text" id="lastname" name="lastname" >

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" >

            <label for="mobile">Mobile Number:</label>
            <input type="tel" id="mobile" name="mobile" >

            <button type="submit" value="submit" class="btn-grad">Save</button>
        </form>
        
    </div>
</body>
</html>