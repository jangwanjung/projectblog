<%@ include file="../layout/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<br>
<div class="container">
    <form>
        <input type="hidden" id="id" value="${board.id}">
        <div class="mb-3 mt-3">
            <input type="text" class="form-control" id="title"  name="title" value="${board.title}">
        </div>
        <div class="mb-3">
            <textarea class="form-control summernote" id="content" name="content">${board.content}</textarea>
        </div>

    </form>
    <button id="btn-update" class="btn btn-primary">글수정완료</button>
</div>
<br>

<script>
    $('.summernote').summernote({
        placeholder: 'Hello Bootstrap 4',
        tabsize: 2,
        height: 300
    });
</script>
<script src="/js/board.js"></script>

<%@ include file="../layout/footer.jsp" %>