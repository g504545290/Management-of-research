<%@ page contentType="text/html; charset=gb2312" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("gb2312");%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	   <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	   <title>�����Ŀ����</title>
	</head>
	<body>
		<%@include file="../header.jsp"%>
		<%@include file="teaheader.jsp"%>	
		<br><br><br>
		<form action="markPro.action" method="post">
			<table align="center">
				<tr>
					<td colspan="2" align="center">��������Ŀ��Ϣ</td>
				</tr>
				<tr>
					<td>��Ŀ��Ŀ</td>
					<td><input type="text" name="prName"/></td>
				</tr>
				<tr>
					<td>��Ŀ����</td>
					<td>
						<input type="radio" name="prLevel" value="1" checked/>У��
						<input type="radio" name="prLevel" value="2"/>ʡ��
						<input type="radio" name="prLevel" value="3"/>���Ҽ�
					</td>
				</tr>
				<tr>
					<td>����</td>
					<td><input type="text" name="prFunding"/></td>
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
