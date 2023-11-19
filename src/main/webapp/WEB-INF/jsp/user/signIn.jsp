<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<%--로그인 제목 영역 --%>
	<div>
		<h3 class="text-center mt-2">로그인</h3>
		<hr>
	</div>
	
	<%--로그인 박스 --%>
	<div class="login-box">
		<form id="loginForm" method="post" action="/user/sign-in" class="d-flex justify-content-center">
			<div>
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text">ID</span>
					</div>
					<input type="text" id="loginId" name="loginId" class="form-control">
				</div>
				
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">PW</span>
					</div>
					<input type="password" id="password" name="password" class="form-control">
				</div>
			</div>
			

			<input type="submit" id="loginBtn" class="btn btn-success ml-3" value="로그인">
		</form>
	</div>
	
	<div class="text-center mt-3">
		<a href="/user/sign-up-view">회원가입하기</a>
	</div>
	
</div>