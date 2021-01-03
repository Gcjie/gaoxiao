<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.jf.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jf.dao.StudentDao" %>
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>奖励管理</title>
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
    <li class="layui-nav-item"><a href="adm-main.jsp">学生基本信息</a></li>
    <li class="layui-nav-item layui-this"><a href="">学生奖励信息</a></li>
    <li class="layui-nav-item"><a href="adm-penalties.jsp">学生处罚信息</a></li>
</ul>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <form class="layui-form layui-col-space5" action="SelectRewardServlet" method="post">
                        <div class="layui-input-inline layui-show-xs-block">
                            <input type="text" name="stuNum" placeholder="请输入学号" autocomplete="off" class="layui-input"></div>
                        <div class="layui-input-inline layui-show-xs-block">
                            <button class="layui-btn" lay-submit="" lay-filter="sreach">
                                <i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </form>
                </div>

                <div class="layui-card-header" style="float: left">
                    <button class="layui-btn" onclick="xadmin.open('增加奖励','./addReward.html',600,500)">添加</button>
                </div>
                <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;" onclick="location.reload()" title="刷新">
                    <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
                </a>
                <div class="layui-card-body ">
                    <table class="layui-table layui-form">
                        <thead>
                        <tr>
                            <th>奖励编号</th>
                            <th>获奖学号</th>
                            <th>奖励名称</th>
                            <th>奖励单位</th>
                            <th>奖励级别</th>
                            <th>操作</th></tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${reward }" var="i">
                            <tr>
                                <td>${i.jlId}</td>
                                <td>${i.jlNum}</td>
                                <td>${i.jlName}</td>
                                <td>${i.jlUnit}</td>
                                <td>${i.jlLevel}</td>
                                <td class="td-manage">
                                        <a title="修改" onclick="xadmin.open('修改信息','UpdateRewServlet?jlId=${i.jlId}',600,400)" >
                                            <i class="layui-icon">&#xe63c;</i></a>
                                    <a title="删除" onclick="location.reload()" href="DelRewardServlet?jlId=${i.jlId}">
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