let member={
	init:function(){
		$("#btnDelete").on("click",()=>{
			this.delete();
		});
	},
	delete:function(){
		alert("delete");
		$.ajax({
			type:"DELETE",
			url:$("#id").text()
		})
		.done(function(resp){
			alert(resp+"번 글이 삭제");
			location.href="/";
		})
		fail(function(error){
			alert(error);
		})
	}
}

member.init();
