<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Đăng nhập</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->

    <link rel="stylesheet" type="text/css" href="css/style.css">

    <style>
        @import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap');
    </style>
    <style type="text/css">
        body{
            font-family: 'Roboto', sans-serif;
            background-image: url('img/organicproduce.jpg');
            background-size: cover;
        }
        .container{
            width: 400px;
            height: 560px;
            padding: 30px 0 0 0;
            margin: 50px auto;
            display: flex;
            flex-direction: column;
            align-items: center;
            border-radius: 15px;
            background-color: white;
            box-shadow: 0px 0px 15px #444;
        }
        .shadow{
            box-shadow: 0px 1px 20px #eee;
        }
        form h2{
            text-align: center;
            font-weight: bold;
            font-size: 1.8rem;
            color: #307213;
            margin: 30px auto;
        }
        input{
            border:none;
            font-size: 1rem;
            width: 90%;
            background-color: transparent;
            height: 50px;
            padding: 0 16px;
            font-weight: 700;
            outline: none;
        }
        .input-gr{
            margin: 10px auto 20px;
            font-size: .8rem;
            width: 300px;
            height: 50px;
            border-radius: 16px;
            padding: 0;
        }
        .label{
            margin-left: 8px;
            font-weight: 700;
            font-size: .7rem;
        }
        ::placeholder{
            color: #307213;
            font-weight: 700;
            font-size: .9rem;
            text-shadow: 0 0 2px #ddd;
        }

        .submit{
            width: 160px;
            height: 50px;
            margin: 30px auto 50px;
            padding: 0;
            transform: translateX(-3px);
        }
        button{
            width: 165px;
            height: 100%;
            border-radius: 50px;
            border:none;
            background-color: #5bb403;
            color: white;
            font-weight: 700;
            margin: auto;
            outline: none;
        }
        .dot {
            height: 47px;
            width: 47px;
            box-shadow: 0 0 15px #ccc;
            border-radius: 50%;
            display: inline-block;
            margin: 10px 4px;
            font-family: "Roboto", sans-serif;
            font-size: 32px;
            color: #005ab1;
            font-weight: bold;
            line-height: 50px;
            cursor: pointer;
        }
    </style>
</head>

<body>
<div id="preloder">
    <div class="loader"></div>
</div>


<div class="container">
    <form action="login" method="post">
        <h2 style="text-shadow:0px 0px 2px #aaa;">Đăng Nhập</h2>

        <div class="input-gr shadow">
            <input id="name" type="text" name="user" placeholder="Email">
        </div>
        <div class="input-gr shadow">
            <input id="password" type="password" name="pass" placeholder="Mật khẩu">
        </div>

        <p style="height:5px; color:red; font-size: .9rem ; text-align: center">${mess}</p>
        <input type="hidden" name="from" value="${param.from}">

        <div class="submit">
            <button class="shadow" type="submit" style="cursor: pointer">ĐĂNG NHẬP</button>
        </div>

        <div style="color: #999; font-size: .9rem; font-weight: 500; text-align: center;">
            Hoặc đăng nhập bằng
        </div>

        <div class="icon" style="text-align: center;">
            <div class="dot">
                <div style="user-select: none;">f</div>
            </div>
            <div class="dot">
                <img src="img/search.png" style="width: 25px; height: 25px;">
            </div>
        </div>
    </form>
    <div class="sign-up" style="margin-top: 50px;">
       Bạn chưa có tài khoản? <a href="signup.jsp" style="text-decoration: underline; color: #307213; font-weight: 500; cursor: pointer;">Đăng Ký</a>
    </div>
</div>

<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/jquery.slicknav.js"></script>
<script src="js/mixitup.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>