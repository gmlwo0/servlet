<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POST form태그 - 서버페이지</title>
</head>
<body>
	<%
		// request params
		String nickname = request.getParameter("nickname");
		String hobby = request.getParameter("hobby");
		String animal = request.getParameter("animal");
		String[] foodArr = request.getParameterValues("food");// 여러개 항목 받을 때 스트링 배열
		String fruit = request.getParameter("fruit");
	%>
	
	<table border="1">
		<tr>
			<th>별명</th>
			<td><%= nickname %></td>
		<tr>
			<th>취미</th>
			<td><%= hobby %></td>
		<tr>
			<th>선호하는 동물</th>
			<td><%= animal %></td>
		<tr>
			<th>선호하는 음식</th>
			<td>
				<%
					if (foodArr != null) {
						String result = "";
						for (String food : foodArr) {
							result += food + ",";
						}
						
						// 맨 뒤에 붙은 ,(콤마) 제거
						// abc -> ab만 추출  substring(0,2) => 2 => 문자열길이-1
						result = result.substring(0,result.length()-1);
							out.print(result);
					}
				%>
			</td>
		<tr>
			<th>선호하는 과일</th>
			<td><%= fruit %></td>												
		</tr>
	</table>
</body>
</html>