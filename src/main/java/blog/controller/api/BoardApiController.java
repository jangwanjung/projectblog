package blog.controller.api;

import blog.config.auth.PrincipalDetail;
import blog.dto.ResponseDto;
import blog.model.Board;
import blog.model.Reply;
import blog.repository.ReplyRepository;
import blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal){
        boardService.글쓰기(board,principal.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

    @DeleteMapping("/api/board/{id}")
    public ResponseDto<Integer> delete(@PathVariable int id){
        boardService.글삭제(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

    @PutMapping("/api/board/{id}")
    public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Board board){
        boardService.글수정(id,board);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

    @PostMapping("/api/board/{boardid}/reply")
    public ResponseDto<Integer> replySave(@PathVariable int boardid, @RequestBody Reply reply, @AuthenticationPrincipal PrincipalDetail principal){

        boardService.댓글쓰기(boardid,reply,principal.getUser());

        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

    @DeleteMapping("/api/board/{boardid}/reply/{replyid}")
    public ResponseDto<Integer> replydelete(@PathVariable int replyid){
        boardService.댓글삭제(replyid);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

}
