<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
	<%--후기작성하기 제목 영역 --%>
	<div>
		<h3 class="text-center mt-2"> 후기 작성하기</h3>
		<hr>
	</div>
	
	<%--파일 업로드 영역 --%>
	<div class="mb-4">
		<input type="file" id="file" accept=".jpg, .jpeg, .png, .gif">
	</div>
	
	<%--글 작성 영역 --%>
	<textarea id="content" class="form-control" rows="10" placeholder="후기를 입력하세요"></textarea>
	
	<%--버튼들 --%>
	<div class="d-flex justify-content-between mt-3">
		<a href="#" class="btn btn-outline-secondary">목록</a>
	
		<div>
			<button type="button" id="saveBtn" class="btn btn-outline-info" data-mountain-id="${mountain.id}">작성완료</button>
		</div>
	</div>
	
</div>

<script>
$(document).ready(function() {
	//글 저장 버튼
	$('#saveBtn').on('click', function() {
		//alert("저장버튼");
		
		let mtId = $(this).data('mountain-id');
		console.log(mtId);
		
		let content = $('#content').val();
		let fileName = $('#file').val(); //[object HTMLInputElement]
		//alert(file); 
		
		//validation check
		if (!content) {
			alert("내용을 입력하세요.");
			return;
		}
		
		//파일이 업로드 된 경우에만 확장자 체크
		if (fileName) {
			//alert("파일이 있다");
			let ext = fileName.split(".").pop().toLowerCase();
			//alert(ext); //jpg
			
			if ($.inArray(ext, ['jpg', 'jpeg', 'png', 'gif']) == -1) { //배열 안에 이(['jpg', 'jpeg', 'png', 'gif']) ext가 있나?
				//-1 : 인덱스가 없다(=이미지가 아니다)는 의미	
				alert("이미지 파일만 업로드 할 수 있습니다");
				$('#file').val(""); //이미지 파일이 아닌게 선택 되면 지운다
				return;
			}
		}
		
		//return; //임시코드 (서버에 보내지 않도록)
		
		//이미지 업로드시 반드시 form 태그가 잇어야한다
		//1. 위쪽 태그를 form으로 구성하거나 
		//2. javascript로 form태그를 만들거나.
		let formData = new FormData();
		formData.append("content", content); // key는 form 태그의 name 속성과 같고 Request parameter명이 된다.
		formData.append("file", $('#file')[0].files[0]);
		
		$.ajax({
			//request
			type:"post"
			, url:"/review/create"
			, data:formData //사진파일까지 잇으면 json으로 못보냄 왜냐면 json은 string인데 파일 덩어리는 string일 수가 없어서.
			, enctype:"multipart/form-data" // 파일 업로드를 위한 필수 설정
			, processData:false // 파일 업로드를 위한 필수 설정
			, contentType:false // 파일 업로드를 위한 필수 설정, string이 아니라고 알려주는 설정
			
			//response
			, success:function(data) {
				if (data.result == "성공") {
					alert("후기가 저장되었습니다.");
					location.href = "/mountain/mountain-review-view?mtId=${mountain.id}";
				} else { //로직 실패
					alert(data.errorMessage);
				}
			}
			, error:function(request, status, error) {
				alert("글을 저장하는데 실패했습니다.");
			}
			
		});
	});
});

</script>