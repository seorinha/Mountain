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
	
	<%--홈 산 목록 영역 --%> 
	<div class="bookmark-box rounded">
		<div class="p-3">
			<a href="/mountain/mountain-review-view?mtId=${mountain.id}">
				<h3 class="font-weight-bold">${mountain.mtName}</h3>
			</a>
			<h6>${mountain.mtLocation}</h6>
			<div class="d-flex justify-content-end align-items-center mr-3">
				<a href="#">
					<img src="https://cdn4.iconfinder.com/data/icons/basic-ui-2-line/32/star-bookmark-favorite-rating-rate-256.png" width="25" height="25" alt="즐겨찾기">
				</a>
			</div>
		</div>
	</div>
	
</div>
