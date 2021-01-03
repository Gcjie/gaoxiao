<%@ page import="com.jf.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jf.dao.StudentDao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="CSS/font.css">
    <link rel="stylesheet" href="CSS/xadmin.css">
    <script src="lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="JS/xadmin.js"></script>
</head>
<body>
<ul class="layui-nav layui-bg-green" lay-filter="">
    <li class="layui-nav-item layui-this"><a href="">学生基本信息</a></li>
    <li class="layui-nav-item"><a href="adm-reward.jsp">学生奖励信息</a></li>
    <li class="layui-nav-item"><a href="adm-penalties.jsp">学生处罚信息</a></li>
</ul>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <form class="layui-form layui-col-space5" action="SelectStudentServlet" method="post">
                        <div class="layui-input-inline layui-show-xs-block">
                            <input type="text" name="stuNum" placeholder="请输入学号" autocomplete="off" class="layui-input"></div>
                        <div class="layui-input-inline layui-show-xs-block">
                            <button class="layui-btn" lay-submit="" lay-filter="sreach">
                                <i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </form>
                </div>
                <div class="layui-card-header" style="float: left">
                    <button class="layui-btn" onclick="xadmin.open('添加用户','./addStudent.html',800,600)">添加</button>
                </div>
                <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;" onclick="location.reload()" title="刷新">
                    <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
                </a>
                <div class="layui-card-body ">
                    <table class="layui-table layui-form">
                        <thead>
                        <tr>
                            <th>学号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>专业</th>
                            <th>班级</th>
                            <th>密码</th>
                            <th>操作</th></tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${student }" var="i">
                        <tr>
                            <td>${i.num}</td>
                            <td>${i.name}</td>
                            <td>${i.sex}</td>
                            <td>${i.major}</td>
                            <td>${i.stuClass}</td>
                            <td>${i.password}</td>
                            <td class="td-manage">
                                <a title="修改" onclick="xadmin.open('修改信息','UpdateServlet?stuNum=${i.num}',600,600)" >
                                    <i class="layui-icon">&#xe63c;</i></a>
                                <a title="删除" onclick="location.reload()" href="DelStudentServlet?stuNum=${i.num}">
                                    <i class="layui-icon">&#xe640;</i></a>
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>