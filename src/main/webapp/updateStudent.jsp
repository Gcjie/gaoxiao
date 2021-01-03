<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="CSS/font.css">
    <link rel="stylesheet" href="CSS/xadmin.css">
    <script src="lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="JS/xadmin.js"></script>
</head>
<style rel="stylesheet" type="text/css">
    body{
        text-align: center;
    }
    .but{
        margin: 20px;
    }
    .xx{
        margin: 10px;
    }
</style>
<body>
<form action="UpdateStudentServlet" method="post">
    <div class="xx">
        <span class="x-red">*</span>姓名
        <div class="layui-input-inline">
            <input type="text" name="stuName" required="" lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="xx">
        <span class="x-red">*</span>性别
        <div class="layui-input-inline">
            <input type="text" name="stuSex" required="" lay-verify="phone" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="xx">
        <span class="x-red">*</span>专业
        <div class="layui-input-inline">
            <input type="text" name="stuMajor" required="" lay-verify="phone" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="xx">
        <span class="x-red">*</span>班级
        <div class="layui-input-inline">
            <input type="text" name="stuClass" required="" lay-verify="phone" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="xx">
        <span class="x-red">*</span>密码
        <div class="layui-input-inline">
            <input type="text" name="stuPassword" required="" lay-verify="phone" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="but">
        <button class="layui-btn" lay-filter="add" lay-submit="">修改</button></div>
    </div>
</form>
</body>
</html>