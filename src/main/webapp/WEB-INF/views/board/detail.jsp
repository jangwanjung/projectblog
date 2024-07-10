<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<br>
<div class="container">
    <input type="hidden" id="id" value="${board.id}">
    <button type="button" class="btn btn-secondary" onclick="history.back()">돌아가기</button>
    <c:if test="${principal.user==board.user}">
        <a href="/board/${board.id}/updateForm" class="btn btn-warning">수정</a>
        <button id="btn-delete" type="button" class="btn btn-danger">삭제</button>
    </c:if>

    <br>
    글 번호 : ${board.id} 작성자 : ${board.user.username}
    <hr>
    <h1>${board.title}</h1>
    <hr>
    ${board.content}
</div>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>