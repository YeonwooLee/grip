package yanoos.exercise.grip;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    //insert문 실행(회원입력)
    @Insert("INSERT INTO temp_user(id,email,nickname) VALUES(123,'aa@aa.a','jyanoos')")
    int saveUser();

    //select문 실행(회원조회)
    @Select("SELECT * FROM temp_user")
    List<User> listUser();


    //동적쿼리 ${}로 감싸면 ''포함 안되고, #{}로 감싸면 ''이 자동으로 포함됩니다
    @Select("SELECT * FROM temp_user where id=${id} AND email=#{email}")
    User showUser(@Param("id")int id, @Param("email")String email);
}