<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMI 계산</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<%
		// request params
	 	int height = Integer.valueOf(request.getParameter("height"));  
		int weight = Integer.valueOf(request.getParameter("weight")); 
		
		// BMI 계산
		double BMI = (weight / ((height / 100.0) * (height / 100.0)));
		String result = null;
		
		// BMI에 따른 결과 구하기
		if (BMI <= 20) {
			//out.print("저체중");
			result = "저체중";
		} else if (BMI <=25) {
			//out.print("정상");
			result = "정상";
		} else if (BMI <= 30) {
			//out.print("과체중");
			result = "과체중";
		} else  {
			//out.print("비만");
			result = "비만";
		}
	%>
	<div class="container">
		<h1>BMI 측정 결과</h1>
		<div class="display-4">당신은 <span class="text-info"><%=result%></span> 입니다.</div>
		<div>BMI 수치:<%= BMI %> </div>
	</div>
</body>
</html>