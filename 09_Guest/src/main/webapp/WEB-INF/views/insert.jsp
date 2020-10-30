<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script src="/myguest/resources/guest.js"></script>
</head>
<body>

<div>
	<form method="post" action="gInsert" >
		<table>
			<tr>
				<td>
					<label for="name">글쓴이</label>
					<input type="text" id="name" name="name" size="20">
				</td>
			</tr>
			<tr>
				<td>
					<label for="content">내용</label>
					<input type="text" id="content" name="content" size="70">
				</td>
			</tr>
			<tr>
				<td>
					<label for="grade">평가</label>
					<input type="radio" name="grade" value="excellent" checked="checked"> 아주잘함(excellent)
					<input type="radio" name="grade" value="good" > 잘함(good)
					<input type="radio" name="grade" value="normal"> 보통(normal)
					<input type="radio" name="grade" value="fail"> 노력(fail)
				</td>
			</tr>
			<tr>
				<td>
				<input type="button" value="입력" id="submit">
				</td>
			</tr>
		</table>
	</form>
	
	<br><hr>
	<div id="resultCount"></div>
	<div id="resultArea">
		<table>
			<thead></thead>
			<tbody></tbody>
		</table>	
	</div>
	
	<div id="pageArea"></div>
	<br><hr>
	
	<div id="viewArea"></div>
</div>

	
</body>
</html>