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
	
	<h1>번호 : ${dto.studNum}</h1>
	<h1>이름 : ${dto.studName}</h1>
	<h1>국어점수 : ${dto.studKor}</h1>
	<h1>영어점수 : ${dto.studEng}</h1>
	<h1>수학점수 : ${dto.studMath}</h1>
	<h1>합계 : ${dto.studTotal}</h1>
	<h1>평균 : ${dto.studAvg}</h1>

	<a href="./update?studNum=${dto.studNum}">수정</a>
	<a href="./delete?studNum=${dto.studNum}">삭제</a>
</body>
</html>