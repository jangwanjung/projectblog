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
    <hr>
    <div>
        <input type="hidden" id="boardid" value="${board.id}">
        <textarea class="form-control" rows="5" id="reply-conetent"></textarea>
        <br>
        <button id="btn-reply-save" class="btn btn-primary">등록</button>
    </div>
    <br>
    <div>
        <ul class="list-group">
            <li class="list-group-item list-group-item-secondary"  >댓글리스트</li>
            <c:forEach var="reply" items="${board.replys}">
                <div>
                    <li class="list-group-item">
                        <div style="display: flex; justify-content: space-between;">
                            <div>
                                    ${reply.content}
                            </div>
                            <div>
                                작성자 : ${reply.user.username} <button>삭제</button>
                            </div>
                        </div>
                    </li>
                </div>
            </c:forEach>

        </ul>
    </div>

<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>