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
	
	<%--산 정보 --%>
	<div class="mountain-review-box">
		<h3 class="font-weight-bold">${mountain.mtName}</h3>
		<div class="d-flex">
			<h6>${mountain.mtLocation}</h6>
			<%--빈 별: 1. 비로그인일 때, 2. 로그인 상태에서 별 누르지않았을 때 --%>
			<a href="#" id="emptyStar" class="bookmark-btn">
				<img src="https://www.iconninja.com/files/961/8/966/star-icon.png" width="18" height="18" alt="empty star">
			</a>
			
			<%--빨간 별: 로그인상태 이면서 즐겨찾기 눌렀을 때 --%>
			<a href="#" id="redStar" class="bookmark-btn">
				<img src="https://www.iconninja.com/files/955/938/464/star-icon.png" width="18" height="18" alt="red star">
			</a>
		</div>
		
		<%--지도api --%>
		<div class="map-box border">
		
		</div>
		
		<%--산 관련 설명들 --%>
		<table class="mount-info-table table table-bordered">
		 
		    <tr>
		      <th scope="row">고도</th>
		      <td>${mountain.mtHeight}</td>
		    </tr>
		    
		    <tr>
		      <th scope="row">산 정보</th>
		      <td>${mountain.mtReason}</td>
		    </tr>
		    
		    <tr>
		      <th scope="row">상행시간</th>
		      <td>${mountain.upMin}</td>
		    </tr>
		    
		    <tr>
		      <th scope="row">하행시간</th>
		      <td>${mountain.downMin}</td>
		    </tr>
		    
		    <tr>
		      <th scope="row">난이도</th>
		      <td>${mountain.difficulty}</td>
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
					    </tr>
				  	</thead>
				  	<tbody>
				  	<c:forEach items="${reviewList}" var="review">
					    <tr>
					      <td>${review.id}</td>
					      <td><a href="#">${review.content}</a></td>
					      <td></td>
					      <td><fmt:formatDate value="${review.createdAt}" pattern="yyyy년 M월 d일 HH:mm:dd" /></td>
					    </tr>
					 </c:forEach>
				 	 </tbody>
				</table>
			</div>
		</c:if>
				<div class="d-flex justify-content-end">
					<%-- <a href="/review/review-create-view" class="btn btn-success" data-mountain-id="${mountain.id}">후기쓰기</a>--%>
					<%-- <button type="button" class="createReview-btn btn btn-success" data-mountain-id="${mountain.id}">후기쓰기</button>--%>
					<a href="/review/review-create-view" class="btn btn-success">후기쓰기</a>
				</div>
				
				<%--paging --%>
	</div>
</div>
