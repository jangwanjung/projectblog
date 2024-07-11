package blog.service;

import blog.model.Board;
import blog.model.Reply;
import blog.model.User;
import blog.repository.BoardRepository;
import blog.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;


    public Page<Board> 글목록 (Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    public Board 글상세보기(int id){
        return boardRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("글상세보기 실패");
        });
    }

    public void 글쓰기(Board board, User user){
        board.setUser(user);
        boardRepository.save(board);
    }

    public void 글삭제(int id){
        boardRepository.deleteById(id);

    }

    @Transactional
    public void 글수정(int id, Board requestboard){
        Board board = boardRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("글찾기 실패 : id를 찾을수없습니다");
        });
        board.setTitle(requestboard.getTitle());
        board.setContent(requestboard.getContent());
    }

    public void 댓글쓰기(int boardid, Reply reply,User user){
        Board board = boardRepository.findById(boardid).orElseThrow(()->{
            return new IllegalArgumentException("보드아이디를 찾을수 없습니다");
        });
        reply.setBoard(board);
        reply.setUser(user);
        replyRepository.save(reply);
    }

    public void 댓글삭제(int replyid){
       replyRepository.deleteById(replyid);

    }
}
