<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<%--산 정보 제목 영역 --%>
	<div>
		<h3 class="text-center mt-2">산 정보</h3>
		<hr>
	</div>
	
	<%--산 정보 --%>
	<div class="info-review-box">
		<h3 class="font-weight-bold">ㅇㅇ산</h3>
		<div class="d-flex">
			<h6>산 소재지</h6>
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
		 <tbody>
		    <tr>
		      <th scope="row">고도</th>
		      <td>m</td>
		    </tr>
		    
		    <tr>
		      <th scope="row">산 정보</th>
		      <td>adfasdfasdfadfasdfafasdf</td>
		    </tr>
		    
		    <tr>
		      <th scope="row">상행시간</th>
		      <td></td>
		    </tr>
		    
		    <tr>
		      <th scope="row">하행시간</th>
		      <td></td>
		    </tr>
		    
		    <tr>
		      <th scope="row">난이도</th>
		      <td></td>
		    </tr>
 			 </tbody>
		</table>
	</div>
	<%--산정보 박스 끝 --%>
	
	
	<%--후기 영역 --%>
	<div>
		<h5 class="text-center mt-2">oo산 후기</h5>
		<hr class="review-hr">
		
		<%-- 후기 리스트 테이블 --%>
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
				    <tr>
				      <td></td>
				      <td><a href="#"></a></td>
				      <td></td>
				      <td></td>
				    </tr>
			 	 </tbody>
			</table>
			
			<div class="d-flex justify-content-end">
				<a href="/review/review-create-view" class="btn btn-success">후기쓰기</a>
			</div>
			
			<%--paging --%>
			
			
		</div>
	</div>
</div>