<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
	<%--산 정보 제목 영역 --%>
	<div>
		<h3 class="text-center mt-2">산 정보</h3>
		<hr>
	</div>
	
	<%--산 정보 박스 --%>
	<div class="mountain-review-box">
		<h3 class="font-weight-bold">${mountain.mtName}</h3>
		<div class="d-flex justify-content-between">
			<h6>${mountain.mtLocation}</h6>
			
			<div class="mr-4 mb-3">
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
		
		<%--지도api --%>
		<div id="map" class="map-box border"></div>
		
		<%--산 관련 설명들 --%>
		<table class="mount-info-table table table-bordered">
		 
		    <tr>
		      <th scope="row">고도</th>
		      <td>${mountain.mtHeight}</td>
		    </tr>
		    
 			 
		</table>
	</div>
	<%--산정보 박스 끝 --%>
	
	
	<%--후기 영역 --%>
	<div>
		<h5 class="text-center mt-2">${mountain.mtName}후기</h5>
		<hr class="review-hr">
		
		<%-- 후기 리스트 테이블 --%>
		<c:if test="${empty reviewList}">
				<div class="font-weight-bold text-center">작성된 리뷰가 없습니다.</div>
		</c:if>
		<c:if test="${not empty reviewList}">
			<div class="review-table">
				<table class="table">
	  				<thead class="thead-light">
					    <tr>
					      <th>NO.</th>
					      <th>후기내용</th>
					      <th>작성자</th>
					      <th>작성시간</th>
					      <th>조회수</th>
					    </tr>
				  	</thead>
				  	<tbody>
				  	<c:forEach items="${reviewList}" var="review">
					    <tr>
					      <td>${review.id}</td>
					      <td><a href="/review/review-detail-view?reviewId=${review.id}">${review.content}</a></td>
					      <td>${sessionScope.userLoginId}</td>
					      <td><fmt:formatDate value="${review.createdAt}" pattern="yyyy년 M월 d일 HH:mm:dd" /></td>
					      <td>${review.view}</td>
					    </tr>
					 </c:forEach>
				 	 </tbody>
				</table>
			</div>
		</c:if>
		
		<%--paging --%>
		<div class="text-center">
		<c:if test="${prevId ne 0}">
			<a href="/mountain/mountain-review-view?mtId=${mountain.id}&prevId=${prevId}" class="mr-5">&lt;&lt; 이전</a>
		</c:if>	
		<c:if test="${nextId ne 0}">
			<a href="/mountain/mountain-review-view?mtId=${mountain.id}&nextId=${nextId}">다음 &gt;&gt;</a>
		</c:if>
		</div>
		
		<div class="d-flex justify-content-end">
			<%-- <a href="/review/review-create-view" class="btn btn-success" data-mountain-id="${mountain.id}">후기쓰기</a>--%>
			<%-- <button type="button" class="createReview-btn btn btn-success" data-mountain-id="${mountain.id}">후기쓰기</button>--%>
			<a href="/review/review-create-view?mtId=${mountain.id}" class="btn btn-success">후기쓰기</a>
		</div>
				
				
				
				
	</div>
</div>


<script type="text/javascript" src="http://dapi.kakao.com/v2/maps/sdk.js?appkey=166cb8c90554b8d95c8841917a09a6fb&&libraries=clusterer,services&autoload=false"></script>
<script>
window.onload = function () {
	kakao.maps.load(function () {
	//mountain 객체가 존재하는 경우에만 지도를 표시합니다.
	if (${mountain.mtLat} != null && ${mountain.mtLot} != null) {
	    // 지도 표시할 div의 요소를 가져옵니다.
	    var container = document.getElementById('map');
	    
	    // mountain 객체에서 mtLat과 mtLot을 가져와 LatLng 객체를 생성합니다.
	    var centerPosition = new kakao.maps.LatLng(${mountain.mtLat}, ${mountain.mtLot});
	    
	    // 지도 옵션을 설정합니다.
	    var options = {
	        center: centerPosition, // 중심 좌표 설정
	        level: 6 // 확대 수준 설정 (1:세계, 3:대한민국 수준)
	    };
	
	    // 지도를 생성하고 표시합니다.
	    var map = new kakao.maps.Map(container, options);
	
	    // 마커가 표시될 위치를 설정합니다.
	    var markerPosition = centerPosition;
	
	    // 마커를 생성합니다.
	    var marker = new kakao.maps.Marker({
	        position: markerPosition
	    });
	
	    // 마커가 지도 위에 표시되도록 설정합니다.
	    marker.setMap(map);
	} else {
	    // mountain 객체가 없는 경우 콘솔에 메시지를 출력합니다.
	    console.log("Mountain data is empty.");
	}
	})
}
</script>

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
				alert("즐겨찾기 하는데 실패했습니다.");
			}
			
		});
	}); // - 즐겨찾기 끝
	
	//페이징 설정
});

</script>

