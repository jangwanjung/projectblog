package blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// 빈 등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것

@Configuration //빈등록 (IoC관리)
@EnableWebSecurity //security 필터 등록
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소를 접근을 하면 권한 및 인증을 미리 체크하겠다는 뜻
public class SecurityConfigure {

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration
    ) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean // IoC가 됨
    public BCryptPasswordEncoder encodePWD() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // csrf 토큰 비활성 (테스트시 걸어두는게 좋음)
                .authorizeRequests() //아래의 주소로 요청을 받았을때
                    .antMatchers("/", "/blog","/auth/**", "/js/**", "/css/**", "/image/**", "/dummy/**", "/board/{id}") //
                    .permitAll() //인증을 안해도 접근을 허용한다
                    .anyRequest()//이외의 주소로 요청을받았을때
                    .authenticated()//인증을 해야 접근을 허용한다
                .and()
                    .formLogin() //인증이 안되어을때는 아래의 주소도 이동시킨다
                    .loginPage("/auth/loginForm")
                    .loginProcessingUrl("/auth/loginProc") //해당주소로 요청이 오면 시큐리티가 로그인을 가로채서 대신 로그인해준다
                    .defaultSuccessUrl("/"); //로그인하면 해당주소로 이동시킨다
        return http.build();
    }
}