<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>
<div class="container">

	<form action="/action_page.php">
		<div class="mb-3 mt-3">
			<label for="email" class="form-label">Username</label> <input type="text" class="form-control" id="email" placeholder="Enter Username" name="username">
		</div>
		<div class="mb-3">
			<label for="pwd" class="form-label">Password</label> <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
		</div>
		<button type="submit" class="btn btn-primary">로그인</button>
	</form>
</div>
<br>

<%@ include file="layout/footer.jsp"%>