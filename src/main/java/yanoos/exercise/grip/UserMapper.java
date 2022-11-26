package yanoos.exercise.grip;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    //insert문 실행(회원입력)
    @Insert("INSERT INTO temp_user(email,nickname) VALUES('aa@aa.a','jyanoos')")
    int saveUser();

    //select문 실행(회원조회)
    @Select("SELECT * FROM temp_user")
    List<User> listUser();


    //동적쿼리 ${}로 감싸면 ''포함 안되고, #{}로 감싸면 ''이 자동으로 포함됩니다
    @Select("SELECT * FROM temp_user where id=${id} AND email=#{email}")
    User showUser(@Param("id")int id, @Param("email")String email);

    @Select("SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'TEMP_USER'")
    int tempUserTblExistCheck();//있으면 1 없으면 0

    //temp_user라는 이름의 테이블이 없다면 생성함
    @Update("CREATE TABLE IF NOT EXISTS temp_user(ID bigint PRIMARY KEY auto_increment, email VARCHAR(255), nickname VARCHAR(255))")
    int createTempUserTblIfNotExist();//int를 리턴하나 항상 0이 나와서 무의미

}