package blog.config.auth;

import java.util.Collection;
import blog.model.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 UserDetails 타입의 오브젝트를
//스프링 시큐리티의 고유한 세션저장소에 저장을 해준다



       //private에 있는 user는 원래같으면 Class외부에서 접근할수없다 하지만 @Getter어노테이션을 사용하면 접근할수있다
@Getter
public class PrincipalDetail implements UserDetails {

    private User user;  //PrincipalDetail은 User객체를갖고있다 이런걸 콤포지션이라고 한다

    public PrincipalDetail(User user) {
        this.user=user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    //계정이 만료된지 않았는지 리턴한다.(true:만료안됨)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //계정이 잠겨있지 않았는지 리턴한다.(true:잠기지않음)
    @Override
    public boolean isAccountNonLocked() {

        return true;
    }
    //비밀번호가 만료되지않았는지 리턴한다(true:만료안됨)
    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }
    //계정이 활성화(사용가능)인지 리턴한다(true:활성화)
    @Override
    public boolean isEnabled() {

        return true;
    }

    public void setUser(User user) {
        this.user = user;
    }

}