package blog.controller;

import blog.config.auth.PrincipalDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BoardController {

    @GetMapping("/")
    public String index(@AuthenticationPrincipal PrincipalDetail principalDetail) {

        return "index";
    }

    public String board(){

        return "board/detail";
    }
	
}
