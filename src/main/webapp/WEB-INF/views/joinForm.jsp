<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>
<div class="container">

	<form action="/action_page.php">
		<div class="mb-3 mt-3">
			<label for="username" class="form-label">Username</label> <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
		</div>
		<div class="mb-3">
			<label for="password" class="form-label">Password</label> <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
		</div>
		<div class="mb-3">
			<label for="email" class="form-label">Email</label> <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
		</div>
	</form>
	<button id="btn-save" class="btn btn-primary">회원가입완료</button>
</div>
<%-- 아래의 코드를 보면 알아서 resources/static/user.js 로 가서 자바스크립트를 실행시킨다--%>
<script src="/js/user.js"></script>
<br>
<%@ include file="layout/footer.jsp"%>