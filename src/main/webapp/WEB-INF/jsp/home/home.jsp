<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
	<%--산 목록 제목 영역 --%>
	<div>
		<h3 class="text-center mt-2">산 목록</h3>
		<hr>
	</div>
	
	<%--홈 산 목록 영역 --%>
	<c:forEach items="${mountainList}" var="mountain">        
	<div class="mount-box rounded">
		<a href="/mountain/mountain-review-view?mtId=${mountain.id}">
			<div class="p-3">
				<h3 class="font-weight-bold">${mountain.mtName}</h3>
				<h6>${mountain.mtLocation}</h6>
			</div>
		</a>
	</div>
	</c:forEach>
</div>