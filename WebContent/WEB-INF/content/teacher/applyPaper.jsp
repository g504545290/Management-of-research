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
   <script type="text/javascript">
	function save()
	{
		targetForm=document.forms[0];
		targetForm.action="savePap";
	}
	function cancel()
	{
		targetForm=document.forms[0];
		targetForm.action="cancelPap";
	}
	</script>
</head>
<body>
<%@include file="../header.jsp"%>
<%@include file="teaheader.jsp"%>	
<br><br><br>
<%
String paName=(String)session.getAttribute("paName");
List<String> paMember=(List<String>)session.getAttribute("paMember");
double paScore=(double)session.getAttribute("paScore");
int paLevel=(int)session.getAttribute("paLevel");
String level="";
if(paLevel==1)level="��ͨ";
if(paLevel==2)level="����";
if(paLevel==3)level="EI";
if(paLevel==4)level="SCI";
%>
<form action="applyPap.action" method="post">
<table align="center">
	<tr>
		<td>������Ŀ</td>
		<td><input type="text" name="paName" value=<%=paName%> readonly /></td>
	</tr>
	<tr>
		<td>���ļ���</td>
		<td><input type="text" name="paLevel" value=<%=level%> readonly /></td>
	</tr>
	<tr>
		<td>���ķ���</td>
		<td><input type="text" name="paScore" value=<%=paScore %> readonly /></td>
	</tr>
	<tr>
		<td colspan="2" align="center">�������</td>
	</tr>
	<tr>
		<td colspan="2">
			<table align="center" border="1">
				<tr>
					<td>��ʦ����</td>
					<td>��ɫ</td>
					<td>����</td>
				</tr>	
				<%for(int i=0;i<paMember.size();i++){
					String role="������";
					if(i==0) role="������";
				%>
				<tr>
					<td><input type="text" value=<%=paMember.get(i)%> readonly name="name"/></td>
					<td><input type="text" value=<%=role%> readonly name="TRole"></td>
					<td><input type="text" name="score"></td>
				</tr>
			<%}%>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="����" onclick="save()"><input type="reset" value="����">
		               <input type="submit" value="ȡ��" onclick="cancel()"></td>
		<td><input type="submit" value="�ύ"></td>
	</tr>
</table>
</form>
</body>
</html>
