<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="./resources/css/fontawesome/css/all.css">
    <link rel="stylesheet" href="./resources/css/login.css">
</head>
<body>
	<%@ include file="./navbar.jsp" %>
	
	    <main>
	    <h1 class="py-3" style="text-align: center;">Easy Parking</h1>
        <div class="form_container">
            <form class="login_form" action="login" method="post">
                <div class="form-group">
                <label for="username">Username</label>
                <input name="username" type="text" class="form-control" id="username">
                </div>
                <div class="form-group">
                <label for="password">Password</label>
                <input name="password" type="password" class="form-control" id="password">
                </div>
                <input type="radio" name="buyer_seller" value="buyer" checked > buyer </input>  
                <input type="radio" name="buyer_seller" value="seller"> seller </input>   
                <div class="py-2">
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
                <p>Not Registered?</p>
            </form>  
            
            <form action="register" method="post" class="registration_form">
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                </div>
                <div class="form-group">
                    <label for="phone_number">Mobile Number</label>
                    <input name="phone_number" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="username">Username</label>
                    <input name="username" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="Password">Password</label>
                    <input name="password" type="password" class="form-control">
                </div>
                <input type="radio" name="buyer_seller" value="buyer" checked > buyer </input>  
                <input type="radio" name="buyer_seller" value="seller"> seller </input>   
                <div class="py-2">
                    <button type="submit" class="btn btn-primary">Register</button>
                </div>
                <p>Already Registered?</p>    
            </form>
            
            <p class="changeForm" style="color: rgb(55, 55, 223); cursor: pointer;">Register</p>
            
        </div>

    </main>

	<%@ include file="./footer.jsp" %>
	<!-- JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
	<script type="text/javascript" src="./resources/js/login.js"></script>
</body>
</html>