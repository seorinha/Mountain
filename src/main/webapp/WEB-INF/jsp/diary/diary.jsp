<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
	<div class="contents-box">
		<%--글쓰기 영역(로그인된 사람만 보이게) --%>
		<%-- <c:if test="${not empty userId}">--%>
		<div class="write-box border rounded">
			<textarea id="writeTextArea" class="w-100 border-0" placeholder="내용을 입력해주세요"></textarea>
			
			<%--아이콘,버튼 --%>
			<div class="d-flex justify-content-between">
				<div class="file-upload d-flex">
					<%-- file 태그를 숨겨두고 이미지를 클릭하면 file 태그를 클릭한 효과 --%>
					<input type="file" id="file" class="d-none "accept=".jpg, .png, .gif, .jpeg">
					
					<a href="#" id="fileUploadBtn"><img width="35" src="https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-image-512.png"></a>
					
					<%-- 업로드 된 임시 파일명 노출 --%>
					<div id="fileName" class="ml-2"></div>
				</div>
				<button id="writeBtn" class="btn btn-info">게시</button>
			</div>
		</div>
		<%--</c:if> --%>
		
		<%--diary 피드 영역 --%>
		<div class="diary-box mt-4">
			<%-- <c:forEach>--%>
			<%--카드 1개 --%>
			<div class="card border rounded">
				<%--userId, 날짜, 더보기 --%>
				<div>
					<div class="d-flex justify-content-between">
						<span class="font-weight-bold ml-2 mt-2">글쓴이</span>
						
						<%--더보기(내가 쓴 글일 때만 노출, 삭제 또는 수정) --%>
						<%-- <c:if test="${userId eq card.user.id}" > --%>
						<a href="#" class="more-btn">
							<img src="https://www.iconninja.com/files/860/824/939/more-icon.png" width="30">
						</a>
						<%-- </c:if> --%>
					</div>
					<%--날짜 --%>
					<small>
						<fmt:formatDate value="" pattern="yyyy년 M월 d일" />					
					</small>
				</div>		
			</div>		
			<%-- </c:forEach>--%>
		</div>

	</div>
</div>
