package blog.service;

import blog.model.User;
import blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void 회원가입(User user){

        String nowPassword = user.getPassword();
        String endPassword = encoder.encode(nowPassword);
        user.setPassword(endPassword);

        userRepository.save(user);
    }

    @Transactional
    public void 회원수정(User user){
        User persistance = userRepository.findById(user.getId()).orElseThrow(()->{
            return new IllegalArgumentException("회원 찾기 실패");
        });
        String nowPassword = user.getPassword();
        String endPassword = encoder.encode(nowPassword);
        persistance.setPassword(endPassword);
        persistance.setEmail(user.getEmail());
    }
}
