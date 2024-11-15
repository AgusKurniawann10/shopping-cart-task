<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
        }
        
        .login-container {
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            margin: 50px auto;
        }
        
        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        
        button {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }
        
        button:hover {
            background-color: #45a049;
        }
        
        .forgot-password {
            text-align: right;
            font-size: 14px;
        }
    </style>
</head>
<body>
 <div class="login-container">
  <h2>Login</h2>
   <form action="${pageContext.request.contextPath}/login.do" method="POST">
     <input type="text" placeholder="Username" name="user_name">
     <input type="password" placeholder="Password" name="user_password">
      <button type="submit">Login</button>
   </form>
   </div>
    
 <c:if test="${not empty message}">
   <div class="login-container">
      <h3>${message}</h3>
   </div>
 </c:if>
</body>
</html>