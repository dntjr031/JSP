<%@page contentType="text/html;charset=euc-kr"%>
<%@page import="java.util.*"%>

<!DOCTYPE HTML">
<HTML>
 <HEAD>
  <TITLE> main </TITLE>
 </HEAD>

 <BODY>
  <h1>main ������</h1>
  <p>include ����</p>
  <h2>include ������ �̿�</h2>
  <%@include file="copyright.jsp"%>
  <!-- include ������ : Ư�� ������ ���Խ�ų �� ��� - �������� �ҽ��� ���Խ�Ŵ -->

  <h2>include �׼� �±� �̿�</h2>
  <jsp:include page="copyright.jsp"/>
  <!-- include �׼� �±� - �ҽ��� �ƴ� �������� �������� ���Խ�Ŵ -->
 </BODY>
</HTML>
