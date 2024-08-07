<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>
<div class="container">
	<br>
	<c:forEach var="board" items="${boards.content}">
		<div class="card">
			<div class="card-body">
				<h2>${board.title}</h2>
				<a href="/board/${board.id}" class="btn btn-primary">글상세보기</a>
			</div>
		</div>
		<br>
	</c:forEach>
	<ul class="pagination justify-content-center">
		<li class="page-item"><a class="page-link" href="#">Previous</a></li>
		<li class="page-item"><a class="page-link" href="#">1</a></li>
		<li class="page-item"><a class="page-link" href="#">2</a></li>
		<li class="page-item"><a class="page-link" href="#">3</a></li>
		<li class="page-item"><a class="page-link" href="#">Next</a></li>
	</ul>
</div>

<%@ include file="layout/footer.jsp"%>