<%@page contentType="text/html;charset=euc-kr"%>
<%@page import="java.util.Date"%>
<!-- page������(��Ƽ��) - �������� ���� ���� ���� -->

<%
// ��ũ��Ʈ�� - jsp �ڵ带 �ִ� ��
	Date d = new Date();
	String str = d.toLocaleString();

	out.print("<h1>���� ��¥:" + str + "</h1>"); //�������� ����϶�� ��
	// out - ���� ��ü(������ �����̳� ��ü �������� ���� ��� ����)

	//���� �ּ�
	/* ������ �ּ� */
%>

<!DOCTYPE HTML>
<HTML>
 <HEAD>
  <TITLE> now1.jsp </TITLE>
 </HEAD>
<script type="text/javascript">
//�ڹ� ��ũ��Ʈ ����
</script>
 <BODY>
  <!-- html ���� -->
  <h2>�ȳ�</h2>
  <p>���� ��¥�� <%=str%> �Դϴ�.</p>
  <!-- ǥ���� - out.print() �� ���� -->
  <%-- jsp�ּ� --%>

  <!-- http://localhost:9090/testsite/now1.jsp -->
 </BODY>
</HTML>
