<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Guest / 총 게시글 수: ${count } </h1>
<div class="container">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>Seq</th>
				<th>글쓴이</th>
				<th>내용</th>
				<th>평가</th>
				<th>작성일</th>
				<th>ip주소</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${guestlist }" var="guest" varStatus="st">
				<tr>
					<td>${st.count }</td>
					<td><a href="javascript:view(${guest.num })">${guest.num }</a></td>
					<td>${guest.name }</td>
					<td>${guest.content }</td>
					<td>${guest.grade }</td>
					<td>${guest.created}</td>
					<td>${guest.ipaddr }</td>
					<td><a href="javascript:fdelete('${guest.num }', '${guest.name }')">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>	
	</table>
</div>
	
	
	<!-- 페이징 처리 기능 -->
	<div>
	${pageHtml }
	</div>
