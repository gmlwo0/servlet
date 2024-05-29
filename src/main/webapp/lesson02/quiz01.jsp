<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz01</title>
</head>
<body>
	<%-- 1번 --%>
	<%!
		public int sum(int end){
		int sum = 0;
		for (int i = 1; i <= end; i++) {
			sum += i;
		}
		return sum;
	}
	%>

	<%-- 2번 --%>
	<%
	int sum = 0;
	int[] scores = {81, 90, 100, 95, 80};
	for (int i = 0; i < scores.length; i++){
		sum += scores[i];
	}
	double average = sum / (double) scores.length;
	%>
	<br>
	<%-- 3번 --%>
	<%
		List<String> scoreList = Arrays.asList(new String[]{"X", "O", "O", "O", "X", "O", "O", "O", "X", "O"});
		int score = 0;
		for (int i =0; i < scoreList.size(); i++) {
			// out.print(scoreList.get(i));
			if (scoreList.get(i).equals("O")) {
				score += 100 / scoreList.size();
			}
		}
		//out.print(score);
	%>
		
		<br>
	<%-- 4번 --%>
	<%
	String birthDay = "20010820";
	String strYear = birthDay.substring(0,4);
	//out.print(strYear);
	int age = 2024 - Integer.valueOf(strYear);
	%>		
	
	<h2>1부터 50까지의 합은  <%= sum(50) %>  입니다.</h2>
	<h2>채점 결과는 <%= score %>점 입니다.</h2>
	<h2>평균 점수는 <%= average %> 입니다.</h2>
	<h2><%= birthDay %>의 나이는 <%= age %>세 입니다.</h2>
</body>
</html>