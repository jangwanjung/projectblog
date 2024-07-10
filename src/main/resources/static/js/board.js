let index={
    init: function (){
        $("#btn-save").on("click", ()=>{
            this.save();
        }),
        $("#btn-delete").on("click", ()=>{
            this.delete();
        });
    },

    save: function (){
        let data = {
            title: $("#title").val(),
            content: $("#content").val()
        };

        $.ajax({
            type: "POST",
            url: "/api/board",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp){
            alert("글쓰기가 완료되었습니다");
            location.href="/";
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },

    delete: function (){
        let id = $("#id").val();
        console.log(id);
        $.ajax({
            type: "DELETE",
            url: "/api/board/"+id,
            dataType: "json"
        }).done(function (resp){
            alert("게시물 삭제가 완료되었습니다");
            location.href="/";
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    }


}
index.init()