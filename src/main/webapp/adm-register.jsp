<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员注册</title>
    <link rel="stylesheet" href="CSS/adm-register.css">
    <script src="JS/jquery.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="JS/adm-register.js"></script>

    <style type="text/css">
        body{
            background-image: url("IMAGE/shanshui.jpg");
        }
    </style>
    <script>
        $(function () {
            //验证用户名
            $('#password1').click(function () {
                var username = $('#username').val();
                var url = 'TestServlet';
                $.ajax({
                    async:true,
                    contentType:"application/x-www-form-urlencoded",
                    data:"username="+username,
                    dataType:"text",
                    type:"GET",
                    url:url,
                    error:function (xhr,statusText,e) {
                        console.log(statusText);
                    },
                    success:function (data) {
                        var json = JSON.parse(data);
                        $('#info').text(json.msg);
                    }
                });
            });
        })
    </script>
</head>
<body>
<div>
    <h1>管理员|注册</h1>
</div>
<div class="test">
    <form action="AdminRegisterServlet" method="post">
        请输入账号：<input id="username" name="username" value="" type="text" placeholder="请输入用户名"><br>
        <span id="info" style="font-family: 幼圆;font-size: 20px;color: red">

            </span>
         <br>
        请输入密码：<input id="password1" name="password1" type="password" placeholder="请输入密码"><br>
        <br>
        请确认密码：<input name="password2" type="password" placeholder="请再次输入密码"><br>
        <br>
        <input type="submit" class="zc" value="注册">
    </form>
</div>
</body>
</html>