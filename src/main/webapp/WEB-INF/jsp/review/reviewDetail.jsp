<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <div>
 	<%--후기 상세보기 제목 영역 --%>
	<div>
		<h3 class="text-center mt-2">ㅇㅇ산 후기 상세보기</h3>
		<hr>
	</div>
	
	<%--파일이 있을 때만 파일 영역추가 --%>
	
	<div class="mb-4">
		<input type="file" id="file" accept=".jpg, .jpeg, .png, .gif">
	</div>
	
	<%--후기글 영역 --%>
	<textarea id="content" class="form-control" rows="10" placeholder="후기를 입력하세요"></textarea>
	
	<%--버튼들 --%>
	<div class="d-flex justify-content-between mt-3">
		<a href="/info/info-review-view" class="btn btn-outline-secondary">목록</a>
	
		<div>
			<button type="button" id="deleteBtn" class="btn btn-outline-danger">삭제</button>
			<button type="button" id="saveBtn" class="btn btn-outline-warning">수정</button>
		</div>
	</div>
 </div>