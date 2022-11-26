package yanoos.exercise.grip;

import static org.junit.Assert.*;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserMapperTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfiguration.class);
    UserMapper userMapper = ac.getBean(UserMapper.class);

    @Test
    public void 매퍼테스트(){
        //given 두번 추가
        userMapper.saveUser();
        userMapper.saveUser();
        //when
        List<User> users = userMapper.listUser();

        // then
        Assertions.assertThat(users.size()).isEqualTo(2);//1로 바꾸면 틀리는 거확인
    }


}