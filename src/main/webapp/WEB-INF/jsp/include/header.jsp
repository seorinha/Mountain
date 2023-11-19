<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<%--logo --%>
	<div>
	
	</div>
	<%--메뉴 --%>
	<div class="menu d-flex justify-content-end pt-3">
		<nav>
			<ul class="nav">
				<li class="nav-item">
					<a href="#" class="nav-link text-white">산 목록</a>
				</li>
				<li class="nav-item">
					<a href="#" class="nav-link text-white">등산일지</a>
				</li>
				<li class="nav-item">
					<a href="#" class="nav-link text-white">즐겨찾기</a>
				</li>
			</ul>
		</nav>
		
		<%--로그인 정보 --%>
		<div class="d-flex justify-content-end pt-2">
			<a href="/user/sign-in-view" class="menu-login text-white">로그인</a>
		</div>
	</div>
</div>