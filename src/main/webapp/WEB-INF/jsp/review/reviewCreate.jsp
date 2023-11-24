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
			<button type="button" id="saveBtn" class="btn btn-outline-info">작성완료</button>
		</div>
	</div>
	
</div>