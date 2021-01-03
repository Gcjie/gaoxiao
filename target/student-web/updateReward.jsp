<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/1/2
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
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
<form action="UpdateRewardServlet" method="post">
    <div class="xx">
        <span class="x-red">*</span>获奖学号
        <div class="layui-input-inline">
            <input type="text" name="jlNum" required="" lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="xx">
        <span class="x-red">*</span>奖励名称
        <div class="layui-input-inline">
            <input type="text" name="jlName" required="" lay-verify="phone" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="xx">
        <span class="x-red">*</span>奖励单位
        <div class="layui-input-inline">
            <input type="text" name="jlUnit" required="" lay-verify="phone" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="xx">
        <span class="x-red">*</span>奖励级别
        <div class="layui-input-inline">
            <input type="text" name="jlLevel" required="" lay-verify="phone" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="but">
        <button class="layui-btn" lay-filter="add" lay-submit="">修改</button></div>
    </div>
</form>
</body>
</html>