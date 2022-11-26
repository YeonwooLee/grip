package yanoos.exercise.grip;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/test")
    public String join(Model model){
        userService.joinUser(); //회원 입력
        List<User> users = userService.showUser(); //회원조회
        model.addAttribute("users",users);


        int id = 1;
        String email = "aa@aa.a";
        User oneUser = userService.showOneUser(id,email);
        model.addAttribute("oneUser",oneUser);

        log.info("참참참");
        return "user";
    }
}