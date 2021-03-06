<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/WEB-INF/views/include/aHeader.jsp" %>
   <style>
   a{
   color:black;}
</style>
<br><br>
   <section class="confirmation_part section_padding">
    <div class="container"> 
       <h4 align="center">All Shop</h4><br>   
       <div id="count" align="left">총 가게 수: ${count }</div>
       <div class="row">
        <div class="col-lg-12">
            <table class="table table-borderless">
            <thead>
              <tr>
                <th scope="col">ShopID(아이디)</th>
                <th scope="col">ShopName(가게이름)</th>                
                <th scope="col">Name(주인)</th>
                <th scope="col">Tel</th>
              </tr>
            </thead>
            <tbody>
             <c:forEach items="${list}" var="list" varStatus="vs">
              <tr style = "cursor:pointer;" onClick = "location.href='/admin/'" >
                <td>
           		 <h5>${list.email}</h5>
                </td>
                
                <td>
           		 <a href="/admin/sDetail/${list.email}"><h5>${list.sname}</h5></a>
                </td>
                
                <td>
           		 <h5>${list.name}</h5>
                </td>
                                
                <td>
           		 <h5>${list.phone}</h5>
                </td>

              </tr>
              
             </c:forEach>
            </tbody>
          </table>
          
          <div id="pageArea" align="center">
          	${pageHtml }
          </div>
          
          <div>
          	<form name="search" id="search">
          		<select name="field" id="field">
					<option value="sname">가게명</option>
					<option value="email">아이디</option>
				</select>
				<input type="text" name="word" id="word">
				<input type="button" value="찾기" id="btnSearch" class="btn btn-default">
          	</form>
          </div>
          
        </div>
      </div>
	</div>
</section>


<script>
function getData(pageNum, field, word){


	$.get("/admin/sSearch",
			{"pageNum":pageNum, "field":field, "word":word},
			function(resp){
				//alert(resp.list);
				var countStr = "<p>검색 건 수: "+resp.count+"</p>";
				$("#count").html(countStr);
				
				var htmlStr = "";
				$.each(resp.list, function(key, val){
					htmlStr+="<tr>";
					htmlStr+="<td><h5>"+val.email+"</h5></td>";
					htmlStr+="<td><a href='/admin/sDetail/"+val.email+"'><h5>"+val.sname+"</h5></a></td>";
					htmlStr+="<td><h5>"+val.name+"</h5></td>";
					htmlStr+="<td><h5>"+val.phone+"</h5></td>";
				});
				$("table tbody").html(htmlStr);
				
				var pageStr="<div align='center'>"+resp.pageHtml+"</div>";
				$("#pageArea").html(pageStr);
					
				
			}//get function
	)//get
}//function

$("#btnSearch").click(function(){
	getData("1",$("#field").val(),$("#word").val());
});

	
</script>

<%@include file ="/WEB-INF/views/include/footer.jsp" %>
