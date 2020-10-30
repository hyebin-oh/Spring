<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

<script>

$(function(){
	//insert 실행할 때 list load 하기
	getData(1,"","");
	
	//insert
	$("#submit").on("click", function(){
		var name=$("#name").val();
		var content=$("#content").val();
		var grade=$("input:radio[name=grade]:checked").val();
		var postString="name="+name+"&content="+content+"&grade="+grade;

		$.ajax({
			type: "post",
			url: "gInsert",
			data: postString,
			success: function(resp){
				$("#listArea").html(resp);
			},
			error: function(e){
				alert("error: "+ e);
			}
		})		
	})
})


function getData(pageNum, field, word){
	$.get("gList", 
		  {"pageNum": pageNum, "field":field, "word":word},
		  function(resp){
			$("#listArea").html(resp);
		  }
	)
}

function view(num){
	$.get("gView",{"num":num},function(resp){
		resp=JSON.parse(resp);
		var htmlStr="";
		htmlStr+="<br>"
		htmlStr+="글쓴이: "+resp.name+"<br>";
		htmlStr+="내용: "+resp.content+"<br>";
		htmlStr+="평가: "+resp.grade+"<br>";
		htmlStr+="작성일: "+resp.created+"<br>";
		htmlStr+="ip주소: "+resp.ipaddr+"<br>";
		$("#viewArea").html(htmlStr);
	})
}

function fdelete(num, name){
	if(confirm("["+name+"]의 게시물을 삭제할까요?")){
		$.get("gDelete", {"num":num}, function(resp){
			$("#listArea").html(resp);
		});
		getData(1,"","");
	}
	
}

</script>
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
</div>

<div align="left">
	<form name ="search" id="search">
		<select name="field" id="field">
			<option value="name">이름</option>
			<option value="content">내용</option>
		</select>
		<input type="text" name="word" id="word">
		<input type="button" value="찾기" id="btnSearch">
	</form>
</div>

<div id="listArea"></div><!-- 리스트 -->

<div id="viewArea"></div><!-- 상세보기 -->
	
</body>
</html>