<%@ page contentType="text/html; charset=gb2312" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>��¼ϵͳ</title>
<s:head/>
</head>
<body>
<%@include file="header.jsp"%>
<table width="960" align="center">
<tr>
<td>
�������û�������������¼<br />
<s:if test="actionMessages.size()>0">
<div class="error">
	<s:actionmessage/>
</div>
</s:if>
<s:actionerror cssClass="error"/>
<div align="center">
<s:form action="login">
	<s:textfield name="user.UID" label="�û���" />
	<s:textfield name="user.password" label="����" />
	<s:radio name="user.role" label="��ɫ" 
		list="#{'1':'���Ա','2':'��ʦ'}" listKey="key" listValue="value"/>
	<tr><td colspan="2">
	<s:submit value="��¼" theme="simple"/><s:reset  theme="simple" value="����"/>
	</td></tr>
</s:form>
</div>
</td>
</tr>
</table>
</body>
</html>
