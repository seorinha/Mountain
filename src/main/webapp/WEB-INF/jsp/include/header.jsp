<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<%--logo --%>
	<div>
		<%--메뉴 --%>
		<div class="menu d-flex justify-content-between pt-3">
		<div class=" d-flex align-items-center ml-3">
		<h1 class="text-white">MOUNT</h1>
		</div>
		<div>
			<nav>
				<ul class="nav">
					<li class="nav-item">
						<a href="/home/home-list-view" class="nav-link text-white">산 목록</a>
					</li>
					<li class="nav-item">
						<a href="/diary/diary-view" class="nav-link text-white">등산일지</a>
					</li>
					<li class="nav-item">
						<a href="/bookmark/bookmark-list-view" class="nav-link text-white">즐겨찾기</a>
					</li>
				</ul>
			</nav>
			</div>
			<%--로그인 정보 --%>
			<div class="d-flex justify-content-end pt-2 mr-4">
			    <c:choose>
			        <c:when test="${not empty kakaoUserName}">
			            <span>${kakaoUserName}님 안녕하세요!</span>
			            <a href="/kakao/logout" class="ml-2">카카오 로그아웃</a>
			        </c:when>
			        <c:otherwise>
			            <c:if test="${not empty userName}">
			                <span>${userName}님 안녕하세요!</span>
			                <a href="/user/sign-out" class="ml-2">로그아웃</a>
			            </c:if>
			        </c:otherwise>
			    </c:choose>
			    
			    <c:if test="${empty userName && empty kakaoUserName}">
			        <a href="/user/sign-in-view" class="menu-login text-white">로그인</a>
			    </c:if>
			</div>
			
		</div>
	</div>
</div>