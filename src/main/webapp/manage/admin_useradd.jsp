<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/6/29
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="admin_menu.jsp"%>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">用户管理</a><span class="crumb-step">&gt;</span><span>新增用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="${pageContext.request.contextPath}/manage/admin_douseradd" method="post" id="myform" name="myform" >
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr>
                            <th><i class="require-red">*</i>用户名：</th>
                            <td>
                                <input class="common-text required" id="title" name="userName" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th>用户姓名：</th>
                            <td><input class="common-text" name="name" size="50" value="admin" type="text"></td>
                        </tr>
                        <tr>
                            <th>密码：</th>
                            <td><input class="common-text" name="passWord" size="50"  type="text"></td>
                        </tr>
                        <tr>
                            <th>确认密码：</th>
                            <td><input class="common-text" name="repassWord" size="50"  type="text"></td>
                        </tr>
                        <tr>
                            <th>性别：</th>
                            <td><input type="radio" name="sex"  value="T" checked="checked">男
                                <input type="radio" name="sex"  value="F" >女
                            </td>
                        </tr>

                        <tr>
                            <th>出生日期：</th>
                            <td><input class="common-text" name="birthday" size="50" value="" type="text"></td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>电子邮箱：</th>
                            <td>
                                <input class="common-text required"  name="Email" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>手机号码：</th>
                            <td>
                                <input class="common-text required"  name="mobile" size="50" value="" type="text">
                            </td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>送货地址：</th>
                            <td>
                                <input class="common-text required"  name="address" size="50" value="" type="text">
                            </td>
                        </tr>

                            <th></th>
                            <td>
                                <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                            </td>
                        </tr>
                        </tbody></table>
                </form>
            </div>
        </div>
    </div>

