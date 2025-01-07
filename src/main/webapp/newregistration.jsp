<%-- 
    Document   : newregistration
    Created on : 31-Jan-2024, 5:18:37 pm
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
         <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
         <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }
        .container {
            max-width: 500px;
            margin: 50px auto;
            background-color: #fff;
            padding: 30px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            margin-bottom: 30px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            font-weight: bold;
        }
        input[type="text"],
        input[type="email"],
        input[type="password"],
        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
    </head>
    <body>
        <div class="container mt-5">
           
         <form action =RegistrationServlet method="post">
             <div class="card">
            <div class="card-header">
                <h1 class="text-center">Create Account</h1>
            </div>
                  <div class="card-body">
         <div class="form-group">
                    <label>Name</label>
             <input type ="text"class="form-control"  placeholder="Enter your Name" name="Name" >
             </div>
                      <div class="form-group">
                    <label>Email</label>
                 <input type ="Email" class="form-control" placeholder="Enter your Email" name="Email" >
                      </div>
            <div class="form-group">
                    <label>Mobile No</label> 
                    <input type ="text" class="form-control" placeholder="Enter your Mobile No" name="mobile_no" >
            </div>
    <div class="form-group">
                    <label>Country</label>    
                    <select class="form-control" name="Country">   
          <<option value="" selected="Country">text</option>
                <option value="" selected disabled>Select Country</option>
                        <option value="America">America</option>
                        <option value="India">India</option>
                        <option value="Russia">Russia</option>
                        <option value="Iran">Iran</option>
                 </select> 
    </div>
 <div class="form-group">
     <label>Address</label> 
     <input type ="text"class="form-control" placeholder="Enter your Address" name="address" >
 </div>
            <div class="form-group">
                    <label>UserID</label>  
                    <input type ="text" class="form-control" placeholder="create your UserId" name="name" >
            </div>
            <div class="form-group">
                    <label>Password</label>  
                    <input type ="Password"class="form-control" placeholder="Enter your Password" name="password" >
                    </div>
                  </div>
                  <div class="card-footer text-center">
                <button type="submit" class="btn btn-primary mr-2">Submit</button>
                <button type="button" class="btn btn-secondary" onclick="window.close()">Close</button>
            </div>

          </div>
         
           
        </form>    
        </div>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
