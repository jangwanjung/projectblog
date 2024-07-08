package blog.repository;

import blog.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository <Reply, Integer> {
}
