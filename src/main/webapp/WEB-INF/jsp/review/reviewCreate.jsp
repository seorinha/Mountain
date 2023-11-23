<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<%--후기작성하기 제목 영역 --%>
	<div>
		<h3 class="text-center mt-2">ㅇㅇ산 후기 작성하기</h3>
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
		<a href="/info/info-review-view" class="btn btn-outline-secondary">목록</a>
	
		<div>
			<button type="button" id="clearBtn" class="btn btn-outline-warning">모두 지우기</button>
			<button type="button" id="saveBtn" class="btn btn-outline-info">작성완료</button>
		</div>
	</div>
	
</div>
<script>
$(document).ready(function() {
	//모두지우기 버튼
	$('#clearBtn').on('click', function() {
		$('#content').val("");
	});
	
	//글 저장 버튼
	$('#saveBtn').on('click', function() {
		//alert("저장");
		let content = $('#content').val();
		let fileName = $('#file').val();
		
		//validation check
		if (!content) {
			alert("후기를 입력하세요");
			return;
		}
		
		if (fileName) { //파일이 있을 때
			let ext = fileName.split(".").pop().toLowerCase();
			
			if ($.inArray(ext, ['jpg', 'jpeg', 'png', 'gif']) == -1) {
				alert("이미지 파일만 업로드 할 수 있습니다");
				$('#file').val("");
				return;
			}
		}
		
		//request param 구성
		let formData = new FormData();
		formData.append("content", content);
		formData.append("file", $('#file')[0].files[0]);
		
		$.ajax({
			//request
			type:"post"
			, url:"/review/create"
			, data:formData
			, enctype:"multipart/form-data" // 파일 업로드를 위한 필수 설정
			, processData:false // 파일 업로드를 위한 필수 설정 
			, contentType:false // 파일 업로드를 위한 필수 설정
			
			//response
			, success:function(data) {
				if (data.result == "성공") {
					alert("후기 작성이 완료되었습니다.");
					location.href = "/info/info-review-view";
				} else {
					alert(data.errorMessage);
				}
			}
		
			, error:function(request, status, error) {
				alert("후기작성에 실패했습니다.");
			}
		});
	});
});
</script>
