<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.jf.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jf.dao.StudentDao" %>
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
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <table class="layui-table layui-form">
                        <thead>
                        <tr>
                            <th>奖励名称</th>
                            <th>奖励单位</th>
                            <th>奖励级别</th>
                        </thead>
                        <tbody>
                        <c:forEach items="${reward }" var="i">
                            <tr>
                                <td>${i.jlName}</td>
                                <td>${i.jlUnit}</td>
                                <td>${i.jlLevel}</td>
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
