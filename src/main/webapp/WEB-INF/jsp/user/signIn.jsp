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
	
	
	<%--카카오 sdk 로드 --%>
	<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.5.0/kakao.min.js" 
 	 integrity="sha384-kYPsUbBPlktXsY6/oNHSUDZoTX6+YI51f63jCPEIPFP09ttByAdxd2mEjKuhdqn4" crossorigin="anonymous">
 	</script>
 
	
	<%--카카오 로그인 버튼 --%>
	<div class="d-flex justify-content-center mt-4">
		<a id="kakao-login-btn" href="https://kauth.kakao.com/oauth/authorize?client_id=1f9ba236274cc877d8d549827331eb10&redirect_uri=http://localhost:8080/kakao/callback&response_type=code">
			<img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" height="45" width="auto" alt="카카오 로그인 버튼">
		</a>
	</div>
	
	
	<div class="text-center mt-3">
		<a href="/user/sign-up-view">회원가입하기</a>
	</div>
</div>

<%--카카오 로그인 --%>

<script>
//166cb8c90554b8d95c8841917a09a6fb
//카카오 sdk 초기화
Kakao.init("166cb8c90554b8d95c8841917a09a6fb");
Kakao.isInitialized();
</script>

 
<script>
$(document).ready(function() {
	//로그인
	$('#loginForm').on('submit', function(e) {
		e.preventDefault();
		
		let loginId = $('input[name=loginId]').val().trim();
		let password = $('#password').val();
		
		if (!loginId) {
			alert("아이디를 입력하세요");
			return false;
		}
		
		if (!password) {
			alert("비밀번호를 입력하세요");
			return false;
		}
		
		//서버로 로그인 정보 보내기
		//ajax
		//form url, params
		let url = $(this).attr('action');
		console.log(url);
		let params = $(this).serialize();
		console.log(params);
		
		$.post(url, params) //request
		.done(function(data) { //response
			if (data.code == 200) {
				location.href = "/home/home-list-view";
			} else {
				alert(data.errorMessage);
			}
		});
		
	});
});
</script>