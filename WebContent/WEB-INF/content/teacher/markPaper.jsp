<%@ page contentType="text/html; charset=gb2312" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("gb2312");%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
   <title>�����������</title>
</head>
<body>
<%@include file="../header.jsp"%>
<%@include file="teaheader.jsp"%>	
<br><br><br>
<form action="markPap.action" method="post">
<table align="center">
	<tr>
		<td colspan="2" align="center">������������Ϣ</td>
	</tr>
	<tr>
		<td>������Ŀ</td>
		<td><input type="text" name="paName"/></td>
	</tr>
	<tr>
		<td>���ļ���</td>
		<td>
			<input type="radio" name="paLevel" value="1" checked/>��ͨ
			<input type="radio" name="paLevel" value="2"/>����
			<input type="radio" name="paLevel" value="3"/>EI
			<input type="radio" name="paLevel" value="4"/>SCI
		</td>
	</tr>
	<tr>
		<td>��Ա</td>
		<td><textarea name="member"></textarea></td>
	</tr>
	<tr>
		<td><input type="submit" value="�������"></td>
		<td><input type="reset" value="����"/></td>
	</tr>
</table>
</form>
</body>
</html>
