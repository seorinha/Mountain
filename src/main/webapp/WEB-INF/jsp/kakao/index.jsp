<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${loginId eq null}">
	<a href="https://kauth.kakao.com/oauth/authorize
            ?client_id=1f9ba236274cc877d8d549827331eb10
            &redirect_uri=http://localhost:8080/home/home-list-view
            &response_type=code">
		<img src="/img/filled-heart.png">
	</a>
</c:if>
<c:if test="${loginId ne null}">
	<h1>로그인 성공입니다</h1>
</c:if>