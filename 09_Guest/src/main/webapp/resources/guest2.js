$(function(){
	getData(1,"","");
});



//전체리스트
function getData(pageNum, field, word){
	$.get("gList",
			{"pageNum":pageNum, "field":field, "word":word},
			function(resp){
				//갯수
				var countStr = "<div align='left'>총 게시물 수: "+resp.count+"</div>";
				$("#resultCount").html(countStr);
				
				//테이블 타이틀
				var htmlTitle="<tr>";
				htmlTitle+="<th>번호</th>";
				htmlTitle+="<th>이름</th>";
				htmlTitle+="<th>평가</th>";
				htmlTitle+="<th>날짜</th>";
				htmlTitle+="<th>삭제</th>";				
				htmlTitle+="</tr>"
				$("#resultArea thead").html(htmlTitle);
				
				//테이블 내용
				var htmlCont="";
				$.each(resp.list, function(key, val){
					htmlCont+=
					`<tr>
						<td>${val.num}</td>
						<td><a href="javascript:fView(${val.num})">${val.name}</a></td>
						<td>${val.grade}</td>
						<td>${val.created}</td>
						<td><a href="javascript:fDelete(${val.num})">삭제</a></td>
					</tr>				
					`
				})
				var container = document.querySelector("#resultArea tbody");
				container.innerHTML=htmlCont;
				
				/*
				var htmlCont = "";
				$.each(resp.list, function(key,val){					
					htmlCont+="<tr><td>"+val.num+"</td>";
					htmlCont+="<td><a href='javascript:fView("+val.num+")'>"+val.name+"</a></td>";
					htmlCont+="<td>"+val.grade+"</td>";
					htmlCont+="<td>"+val.created+"</td>";
					htmlCont+="<td><a href='javascript:fDelete("+val.num+")'>삭제</a></td></tr>";
				});
				*/
				
			//	$("#resultArea tbody").html(htmlCont);
				
				var pageStr="<div align='left'>"+resp.pageHtml+"</div>";
				$("#pageArea").html(pageStr);
				
			}//function
	);//get
}//function

//상세보기
function fView(num){
	$.get("view", 
			{"num":num},
			function(resp){
				//alert(resp);
				var htmlInfo="";1
				htmlInfo+="번호: "+resp.guest.num+"<br>";
				htmlInfo+="이름: "+resp.guest.name+"<br>";
				htmlInfo+="평가: "+resp.guest.grade+"<br>";
				htmlInfo+="날짜: "+resp.guest.created+"<br>";				
				$("#viewArea").html(htmlInfo);
	});//get
}//function

//삭제하기
function fDelete(num){
		if(confirm("["+num+"]의 게시물을 삭제할까요?")){
		$.get("delete", {"num":num},
		   function(resp){
		  	 if(resp=='success'){
				alert("삭제성공");
				getData(1,"","");
			  }
		});	
	}
}
