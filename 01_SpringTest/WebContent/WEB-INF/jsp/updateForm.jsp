<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" ></script>   
</head>
<body>
<h2>${user.id }님의 정보 수정</h2>
<form action="personUpdate.sp" method="post">
	<label for="name">이름:</label>
	<input type="text" id="name" name="name" value=${user.name }><br>
	
	<label for="id">아이디:</label>
	<input type="text" id="userid" name="id" value=${user.id } readonly><br>
	
	<label for="password">패스워드:</label>
	<input type="text" id="password" name="password" value=${user.password }><br>
	
	<label for="man">성별:</label>
	<input type="radio" name="gender" id="man" value="남" checked>남성
	<input type="radio" name="gender" id="woman" value="여">여성<br>
	
	<label for="job">직업:</label>
	<select id="job" name="job">
		<option value="회사원">회사원</option>
		<option value="학생">학생</option>
		<option value="기타">기타</option>
	</select><br>
	
	<script>
	//성별
	if("${user.gender}"=="남"){
		$("input:radio[value='남']".prop("checked", true));
	}else{
		$("input:radio[value='여']".prop("checked", true));
	}

	//직업
	$("#job option").each(function(){
		if($(this).val()=="${user.job}"){
			$(this).prop("selected",true);
		}
	});
	</script>
	
	<input type="submit" value="수정확인">
	<input type="reset" value="취소">
	
</form>
</body>
</html>