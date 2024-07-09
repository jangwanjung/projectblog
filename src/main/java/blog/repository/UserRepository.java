package blog.repository;

import blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User,Integer> {

    //findByUsername을 실행시키면 select * from where username=?; 이 실행된다
    Optional<User> findByUsername(String username);
}
