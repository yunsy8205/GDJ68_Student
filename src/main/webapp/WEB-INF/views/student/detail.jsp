<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Detail</h1>
	
	<h1>��ȣ : ${dto.studNum}</h1>
	<h1>�̸� : ${dto.studName}</h1>
	<h1>�������� : ${dto.studKor}</h1>
	<h1>�������� : ${dto.studEng}</h1>
	<h1>�������� : ${dto.studMath}</h1>
	<h1>�հ� : ${dto.studTotal}</h1>
	<h1>��� : ${dto.studAvg}</h1>

	<a href="./update?studNum=${dto.studNum}">����</a>
	<a href="./delete?studNum=${dto.studNum}">����</a>
</body>
</html>