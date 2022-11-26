package yanoos.exercise.grip;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

@SpringBootTest
public class UserServiceTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfiguration.class);
    UserService userService = ac.getBean(UserService.class);

    @Test
    public void 임시테스트(){
        //given
        userService.joinUser();
        userService.joinUser();
        userService.joinUser();

        //when
        List<User> users = userService.showUser();
        // then
        Assertions.assertThat(users.size()).isEqualTo(3);//4로 바꿔보면 틀리게 나오는거 확인
    }

}