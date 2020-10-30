<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="personForm.sp">추가하기</a><br>
<h2>전체보기</h2>
<table>
	<thead>
      <tr>
      	<th>이름</th>
        <th>아이디</th>
        <th>성별</th>
        <th>직업</th>     
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${userlist }" var="user">
    		<tr>
    			<td>${user.name }</td>
    			<td><a href="personView.sp?id=${user.id }">${user.id }</a></td>
    			<td>${user.gender }</td>
    			<td>${user.job }</td>
    		</tr>
    	</c:forEach>
    </tbody>
</table>
</body>
</html>