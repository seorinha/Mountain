<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <div>
 	<%--후기 상세보기 제목 영역 --%>
	<div>
		<h3 class="text-center mt-2">후기 상세보기</h3>
		<hr>
	</div>
	
	<%--파일이 있을 때만 파일 영역추가 --%>
	<c:if test="${not empty review.imagePath}">
		<div class="my-4">
			<img src="${review.imagePath}" alt="업로드 된 이미지" width="300">
		</div>
	</c:if>
		
	<div class="mb-4">
		<input type="file" id="file" accept=".jpg, .jpeg, .png, .gif">
	</div>
	
	<%--후기글 영역 --%>
	<textarea id="content" class="form-control" rows="10">${review.content}</textarea>
	
	<%--버튼들 --%>
	<div class="d-flex justify-content-between mt-3">
		<a href="mountain/mountain-review-view?mtId=${mtId}" class="btn btn-outline-secondary">목록</a>
	
		<div>
			<button type="button" id="deleteBtn" class="btn btn-outline-danger" data-review-id="${reviewId}">삭제</button>
			<button type="button" id="saveBtn" class="btn btn-outline-warning" data-review-id="${reviewId}" >수정</button>
		</div>
	</div>
 </div>
 
 <script>
 $(document).ready(function() {
	 //글 수정 버튼
	 $('#saveBtn').on('click', function() {
		//alert("글 수정버튼");
		let reviewId = $(this).data("review-id");
		let content = $('#content').val();
		let fileName = $('#file').val();
		//alert(reviewId);
		
		// validation check
		if (!content) {
			alert("내용을 입력하세요.");
			return;
		}
		
		//파일이 업로드 된 경우에만 확장자 체크
		if (fileName) { //파일이 있을 때
			//alert("파일이 있다");
			//확장자만 뽑은 후 소문자로 변경한다
			let ext = fileName.split(".").pop().toLowerCase();
			//alert(ext);
			
			if ($.inArray(ext, ['jpg', 'jpeg', 'png', 'gif']) == -1) { 	
				alert("이미지 파일만 업로드 할 수 있습니다");
				$('#file').val(""); //이미지 파일이 아닌게 선택 되면 지운다
				return;
			}
		}
		
		// request param 구성
		let formData = new FormData();
		formData.append("reviewId", reviewId);
		// key는 form 태그의 name 속성과 같고 Request parameter명이 된다.
		formData.append("content", content);
		formData.append("file", $('#file')[0].files[0]);
		
		$.ajax({
			// request
			type:"put" //put은 post의 일종이다
			, url:"/review/update"
			, data:formData
			, enctype:"multipart/form-data" // 파일 업로드를 위한 필수 설정
			, processData:false // 파일 업로드를 위한 필수 설정
			, contentType:false // 파일 업로드를 위한 필수 설정
			
			// response
			, success:function(data) {
				if (data.result == "성공") {
					alert("후기가 수정되었습니다.");
					location.reload(true);
				} else {
					// 로직 실패
					alert(data.errorMessage);
				}
			}
			, error:function(request, status, error) {
				alert("후기를 저장하는데 실패했습니다.");
			}
		});
	});
		
	//글 삭제 버튼
	$('#deleteBtn').on('click', function(e) {
		//alert("삭제버튼");
		e.preventDefault();
		
		let reviewId = $(this).data("review-id");
		
		$.ajax({
			//request
			type:"delete"
			, url:"/review/delete"
			, data:{"reviewId":reviewId}
		
			//response
			, success:function(data) {
				if (data.code == 200) {
					alert("후기가 삭제되었습니다");
					location.href = "/mountain/mountain-review-view?mtId=${review.mtId}";
				} else {
					alert(data.errorMessage);
				}					
			}
			, error:function(request, status, error) {
				alert("후기 삭제에 실패했습니다.");
			}
		});
	});
 });
 </script>