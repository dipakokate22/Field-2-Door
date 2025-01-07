<%-- 
    Document   : FramerRegistration
    Created on : 05-Feb-2024, 1:44:44 pm
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Framer Registration </title>
        <style>
            .div{
                margin: 5px;
            }
        </style>
    </head>
    <body>
        <h1>Framer Registration</h1>
        <div>
        <form action =FramerRegistrationServlet method="post">
            <center>
            <fieldset>
                
         <legend><h1> Create Account </h1></legend>
            <lablel> Full Name :</lablel>     
          <input type ="text" placeholder="Enter your Name" name="Full_name" ><br>
            <lablel> Email :</lablel>   
           <input type ="Email" placeholder="Enter your Email" name="Email" > <br>
            <lablel> Mobile No :</lablel>  
           <input type ="text" placeholder="Enter your Mobile No" name="mobile_no" ><br>
         <lablel> Country : </lablel>   
          <select  name="Country" style = "width:160px">   
          <<option value="" selected="Country">Country</option>
                <option value ="America">America</option>
                <option value ="India">India</option>
                <option value ="russia">russia</option> 
                <option value ="Iran">Iran</option> 
                 </select> <br>
 <lablel>Address :</lablel>  
            <input type ="text" placeholder="Enter your Address" name="address" ><br>
      <label> Pin Code : </label>
         <input type =" Number" placeholder="Enter Pin No" name ="pin_code"><br>

       <lablel>  UserId :</lablel>   
            <input type ="text" placeholder="create your UserId" name="UserId" ><br>
            <lablel> Password :</lablel> 
            <input type ="Password" placeholder="Enter your Password" name="password" > <br>
            <lablel>conform Password :</lablel> 
            <input type ="Password" placeholder="conform Password" name="conform_password" > <br>
            
            <button>Submit </button>  <br>
                                            
                                            
          
         
            </fieldset>
                <a href="FramerLogin.jsp"> Login <a> 
             </center>
        </form>    
        </div>
    </body>
</html>
