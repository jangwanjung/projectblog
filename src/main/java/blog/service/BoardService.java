package blog.service;

import blog.model.Board;
import blog.model.User;
import blog.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;


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
}
