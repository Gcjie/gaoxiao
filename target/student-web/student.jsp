<%@ page import="com.jf.bean.Student" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/12/30
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学生页面</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="CSS/font.css">
    <link rel="stylesheet" href="CSS/xadmin.css">
    <script src="lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="JS/xadmin.js"></script>
    <style>
        .stu{
            margin: 200px;
        }
        .stu .stu-table{
            margin: 60px;
        }
        .stu .stu-button{
            margin: 0 0 0 150px;
        }
    </style>
</head>
<body>

<div class="stu">
    <div class="stu-table">
        <table class="layui-table">
            <tr>
                <td>学号</td>
                <td>
                    ${stu.num}
                </td>
            </tr>
            <tr>
                <td>姓名</td>
                <td>
                    ${stu.name}
                </td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    ${stu.sex}
                </td>
            </tr>
            <tr>
                <td>专业</td>
                <td>
                    ${stu.major}
                </td>
            </tr>
            <tr>
                <td>班级</td>
                <td>
                    ${stu.stuClass}
                </td>
            </tr>
        </table>

    </div>
    <div class="layui-row layui-col-space10 stu-button">
        <div class="layui-col-md4">
            <button onclick="xadmin.open('获奖','./LookRewardServlet',400,400)" class="layui-btn">查看获奖</button>
        </div>
        <div class="layui-col-md4">
            <button onclick="xadmin.open('处罚','./LookPenaltiesServlet',400,400)" class="layui-btn">查看处罚</button>
        </div>
        <div class="layui-col-md4">
            <button onclick="xadmin.open('修改密码','./updatePass.html',400,200)" class="layui-btn layui-btn-normal">修改密码</button>
        </div>
    </div>
</div>
</body>
</html>