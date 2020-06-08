<%@page contentType="text/html;charset=euc-kr"%>

<%!
	//선언부 - 멤버변수나 메서드 정의
	//멤버 변수
	String id = "hong";

	//메서드
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
	//스크립트릿 - 자바 코드 작성
	//여기서 선언하는 변수는 지역변수임
	int num1 = 10, num2 = 20;
	String name="홍길동";

	int result = add(num1,num2);
	out.println("멤버변수 id=" + id + "<br>");
	out.println("지역변수 name=" + name + "<br>");
	out.println("두 수의 합 =" + result + "<br>");

	id = "kim";
	name = "김길동";
  %>

  <h1>값 변경 후</h1>
  <p>id : <%=id%></p>
  <p>name : <%=name%></p>
 </BODY>
</HTML>
