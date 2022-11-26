package yanoos.exercise.grip;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    //회원입력
    public void joinUser(){
        userMapper.saveUser();

    }

    //회원리스트조회
    public List<User> showUser(){
        return userMapper.listUser();
    }

    //회원조회
    public User showOneUser(int id, String email){
        return userMapper.showUser(id,email);
    }

}