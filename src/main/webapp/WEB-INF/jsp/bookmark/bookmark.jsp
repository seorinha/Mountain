<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>
	<%--즐겨찾기 제목 영역 --%>
	<div>
		<h3 class="text-center mt-2">즐겨찾기</h3>
		<hr>
	</div>
	
	<%--즐겨찾기 목록 영역 --%> 
	<c:forEach items="${bookmarkList}" var="bookmark"> 
	<div class="mount-box rounded mb-2">
		<div class="d-flex align-items-center justify-content-between">
			<a href="/mountain/mountain-review-view?mtId=${mountain.id}">
				<div class="p-3">
					<h3 class="font-weight-bold">${mountain.mtName}</h3>
					<h6>${mountain.mtLocation}</h6>
				</div>
			</a>
			<div class="mr-4">
				<%--빈 별: 1. 비로그인일 때, 2. 로그인 상태에서 별 누르지않았을 때--%>
				<c:if test="${bookmark eq null}">
					<a href="#" id="emptyStar" class="bookmark-btn" data-mountain-id="${mtId}">
						<img src="https://cdn3.iconfinder.com/data/icons/feather-5/24/star-512.png" width="30" height="30" alt="unfilledStar">
					</a>
				</c:if>
					
				<%---빨간 별: 로그인상태 이면서 즐겨찾기 눌렀을 때 --%>
				<c:if test="${bookmark ne null}">
					<a href="#" id="redStar" class="bookmark-btn" data-mountain-id="${mtId}">
						<img src="https://cdn0.iconfinder.com/data/icons/new-year-holidays-set/200/NewYearIcon7-01-512.png" width="30" height="30" alt="filledStar">						</a>
					</a>
				</c:if>
			</div>
		</div>
	</div>
	</c:forEach>
	
</div>
<script>
$(document).ready(function() {
	//즐겨찾기 누르기, 해제
	$('.bookmark-btn').on('click', function(e) {
		e.preventDefault();
		
		let mtId = $(this).data('mountain-id');
		//alert(mtId);
		
		$.ajax({
			//request
			type:"post"
			, url:"/bookmark/" + mtId
			, data:{"mtId":mtId}
			
			//response
			, success:function(data) {
				if (data.code == 200) {
					//alert("즐겨찾기가 저장되었습니다.");
					location.reload(true); // 새로고침 
				} else if (data.code == 500) {
					// 비로그인 상태
					alert(data.errorMessage);
					location.href = "/user/sign-in-view"; // 로그인 페이지로 이동
				}
			}
			, error:function(request, status, error) {
				alert("즐겨찾기를 해제 하는데 실패했습니다.");
			}
			
		});
		
		
	});
});

</script>