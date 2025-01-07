<%-- 
    Document   : AddProduct
    Created on : 13-Feb-2024, 11:42:13 am
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Add Product </title>
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
        <div class="container">
        <h1> Add Product <h1>
        <div class="card">
            <div class="card-body">
                
            <form action =AddProductServlet1 method="post" enctype="multipart/form-data">
           
           <div class="form-group">
             <label for="productName">Product Name:</label>  
                    <input type ="text" placeholder="Product Name" name="Name"/> <br> 
                    </div>
               <div class="form-group"> 
                  <label for="productDetail">Product Detail:</label>                 
                   <textarea class="form-control" id="productDetail" name="detail" ></textarea><br>  
                   </div>
                <div class="form-group">
                    <label for="productCategory">Product Category:</label>
                    <input type ="text" class="form-control" id="productCategory"placeholder="Product category" name="category"/> <br> 
                </div>
                
              <div class="form-group">          
                    <label for="productPrice">Product Price:</label>
                     <input type="Numbert" class="form-control" id="productPrice" placeholder=" product price" name="price"/> <br>
              </div>
                
               <div class="form-group"> 
                     <label for="productQuantity">Product Quantity:</label>
                     <input type="Numbert"class="form-control"id="productQuantity" placeholder=" product Quantity" name ="Quantity"required/>  <br>
               </div>  
                
                <div class="form-group">
                   <label for="productDiscount">Product Discount:</label>
                     <input type="Numbert"class="form-control" id="productDiscount" name ="discount"/>  <br>
                </div>
                <div class="form-group">
                   <label for="productImage">Add Image:</label>
                    <input type ="file" class="form-control-file" id="productImage" name ="image" required/> <br>
                </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                     
                     
                
                </form>
        </div>
      </div>
    </div>           
    </body>
</html>
