<%@ page contentType="text/html; charset=gb2312" language="java" %>
<%@ page import="java.util.*" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	   <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	   <title>�鿴���˿�����Ϣ</title>
</head>
<body>
<%@include file="../header.jsp"%>
<%@include file="teaheader.jsp"%>
<table width="80%" border="0" align="center"
	cellspacing="1" bgcolor="#cccccc">
  <tr bgcolor="#e1e1e1" >
	<td colspan="7" ><div class="mytitle" align="center">����</div></td> 
  </tr>
  <tr class="pt11" height="45">
	<td><b>���ı��</b></td>
	<td><b>������Ŀ</b></td>
	<td><b>���ļ���</b></td>
	<td><b>���ķ���</b></td>
	<td><b>����״̬</b></td>
	<td><b>��ʦ��ɫ</b></td>
	<td><b>��ʦ����</b></td>
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
	<td>
	<s:if test="paStatus==0">δ�ύ</s:if>
	<s:elseif test="paStatus==1">�����</s:elseif>
	<s:elseif test="paStatus==2">���ͨ��</s:elseif>
	<s:elseif test="paStatus==3">��˲�ͨ��</s:elseif>
	</td>
	<td>
    <s:if test="roleScore[0].TRole==0">������</s:if>
	<s:else>������</s:else>
	</td>
	<td><s:property value="roleScore[0].score"/></td>
	</tr>
</s:iterator>
</table>
<br><br>

<table width="80%" border="0" align="center"
	cellspacing="1" bgcolor="#cccccc">
  <tr bgcolor="#e1e1e1" >
	<td colspan="8" ><div class="mytitle" align="center">��Ŀ</div></td> 
  </tr>
  <tr class="pt11" height="45">
	<td><b>��Ŀ���</b></td>
	<td><b>��Ŀ��Ŀ</b></td>
	<td><b>��Ŀ����</b></td>
	<td><b>��Ŀ����</b></td>
	<td><b>��Ŀ����</b></td>
	<td><b>��Ŀ״̬</b></td>
	<td><b>��ʦ��ɫ</b></td>
	<td><b>��ʦ����</b></td>
  </tr>
  <s:iterator value="projects" status="index">  
 	<s:if test="#index.odd == true"> 
		 <tr style="background-color:#dddddd" class="pt11" height="32">
	</s:if> 
	<s:else> 
		 <tr class="pt11" height="32">
	</s:else>
	<td><s:property value="prID"/></td>
	<td><s:property value="prName"/></td>
   	<td>
	<s:if test="prLevel==1">У��</s:if>
	<s:elseif test="prLevel==2">ʡ��</s:elseif>
	<s:elseif test="prLevel==3">���Ҽ�</s:elseif>
	</td>
	<td><s:property value="prFunding"/></td>
	<td><s:property value="prScore"/></td>
	<td>
	<s:if test="prStatus==0">δ�ύ</s:if>
	<s:elseif test="prStatus==1">�����</s:elseif>
	<s:elseif test="prStatus==2">���ͨ��</s:elseif>
	<s:elseif test="prStatus==3">��˲�ͨ��</s:elseif>
	</td>
	<td>
	<s:if test="roleScore[0].TRole==0">������</s:if>
	<s:else>������</s:else>
	</td>
	<td><s:property value="roleScore[0].score"/></td>
	</tr>
</s:iterator>
</table>
</body>
</html>