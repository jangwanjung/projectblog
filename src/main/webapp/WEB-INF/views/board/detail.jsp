<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<br>
<div class="container">
    <button type="button" class="btn btn-secondary">Secondary</button>
    <button type="button" class="btn btn-warning">Warning</button>
    <button type="button" class="btn btn-danger">Danger</button>
    <br>
    글 번호 : ${board.id} 작성자 : ${board.user.username}
    <hr>
    <h1>${board.title}</h1>
    <hr>
    ${board.content}
</div>

<%@ include file="../layout/footer.jsp"%>