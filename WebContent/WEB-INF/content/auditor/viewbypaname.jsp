<%@ page contentType="text/html; charset=gb2312" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
		<title>ͨ���������ֲ�ѯ</title>
	</head>
	<body>
		<%@include file="../header.jsp"%>
		<%@include file="audheader.jsp"%>
		<table width="960" align="center">
			<tr>
				<td>
					<table border="1" align="center" bgcolor="#cccccc">
						<tr class="pt11" height="45">
							<td><b>���ı��</b></td>
							<td><b>������Ŀ</b></td>
							<td><b>���ļ���</b></td>
							<td><b>���ķ���</b></td>
							<td><b>�����˱��</b></td>
							<td><b>����״̬</b></td>
							<td><b>��ʦ���&nbsp;&nbsp;��ʦ��ɫ&nbsp;&nbsp;��ʦ����</b></td>
						</tr>
						<s:iterator value="papers" status="index">  
							<s:if test="#index.odd == true"> 
								<tr style="background-color:#dddddd" class="pt11" height="32">
							</s:if> 
							<s:else> 
								<tr class="pt11" height="32">
							</s:else> 
							<td><s:property value="paID"/></td>
							<td><s:property value="paName"/></td>
   							<td>
								<s:if test="paLevel==1">��ͨ</s:if>
								<s:elseif test="paLevel==2">����</s:elseif>
								<s:elseif test="paLevel==3">EI</s:elseif>
								<s:elseif test="paLevel==4">SCI</s:elseif>
							</td>
							<td><s:property value="paScore"/></td>
							<td><s:property value="paApplicant"/></td>
							<td>
								<s:if test="paStatus==0">δ�ύ</s:if>
								<s:elseif test="paStatus==1">�����</s:elseif>
								<s:elseif test="paStatus==2">���ͨ��</s:elseif>
								<s:elseif test="paStatus==3">��˲�ͨ��</s:elseif>
							</td>
							<td >
								<table align="center" bgcolor="#cccccc" align="center">
								<s:iterator value="roleScore" status="index">	
							 	<s:if test="#index.odd == true"> 
									 <tr style="background-color:#cccccc" class="pt11" height="32">
								</s:if> 
								<s:else> 
									 <tr class="pt11" height="32">
								</s:else>
								<td width="34%" align="center"><s:property value="teacher.TID"/></td>
								<td width="33%" align="center">
								<s:if test="TRole==0">������</s:if>
								<s:elseif test="TRole==1">������</s:elseif>
								</td>
								<td width="33%" align="center"><s:property value="score"/></td>
								</s:iterator>
								</table>
							</td>
						</s:iterator>
					</table>
				</td>
			</tr>
		</table>			
	</body>
</html>