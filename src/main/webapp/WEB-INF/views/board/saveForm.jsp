<%@ include file="../layout/header.jsp" %>
<br>
<div class="container">
    <form>
        <div class="mb-3 mt-3">
            <input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
        </div>
        <div class="mb-3">
            <textarea class="form-control summernote" id="content" placeholder="Enter content" name="content"></textarea>
        </div>

    </form>
    <button id="btn-save" class="btn btn-primary">글쓰기완료</button>
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