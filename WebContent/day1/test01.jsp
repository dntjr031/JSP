<%@page contentType="text/html;charset=euc-kr"%>

<%!
	//����� - ��������� �޼��� ����
	//��� ����
	String id = "hong";

	//�޼���
	public int add(int a, int b){
		return a+b;
	}
%>
<!DOCTYPE HTML>
<HTML>
 <HEAD>
  <TITLE> day1/test01.jsp </TITLE>
 </HEAD>

 <BODY>
  <%
	//��ũ��Ʈ�� - �ڹ� �ڵ� �ۼ�
	//���⼭ �����ϴ� ������ ����������
	int num1 = 10, num2 = 20;
	String name="ȫ�浿";

	int result = add(num1,num2);
	out.println("������� id=" + id + "<br>");
	out.println("�������� name=" + name + "<br>");
	out.println("�� ���� �� =" + result + "<br>");

	id = "kim";
	name = "��浿";
  %>

  <h1>�� ���� ��</h1>
  <p>id : <%=id%></p>
  <p>name : <%=name%></p>
 </BODY>
</HTML>
