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
<div align="center">
<h2>전체보기 / 총 인원 : ${userCount}</h2>

<table>
	<thead>
      <tr>
      	<th>이름</th>
        <th>아이디</th>
        <th>성별</th>
        <th>직업</th>   
        <th>삭제</th>  
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${userlist }" var="user">
    		<tr>
    			<td>${user.name }</td>
    			<td><a href="personView?id=${user.id }">${user.id }</a></td>
    			<td>${user.gender }</td>
    			<td>${user.job }</td>
    			<td><a href="personDelete?id=${user.id }">삭제</a></td>
    		</tr>
    	</c:forEach>
    </tbody>
</table>
</div>

<div align="center">
	<form action="personList">
		<select name="field" id="field">
			<option value="name">이름</option>
			<option value="id">아이디</option>
		</select>
		<input type="text" name="word" id="word">
		<input type="submit" value="찾기" id="btnSearch">	
	</form>
</div>
</body>
</html>