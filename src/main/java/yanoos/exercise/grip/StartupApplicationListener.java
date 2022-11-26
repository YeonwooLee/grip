package yanoos.exercise.grip;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
//모든 빈이 생성되고 의존성이 주입된 후 실행됨
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    private final UserMapper userMapper;


    public boolean setUp(){
        int tempUserTblExist = userMapper.tempUserTblExistCheck();
        log.info("tempUserTblExist is "+ tempUserTblExist);//테이블이 있으면 1, 없으면 0이 뜬다
        if(tempUserTblExist==0){
            log.info("temp_user 테이블이 없어서 생성합니다");
            int tempUserTblIfNotExist = userMapper.createTempUserTblIfNotExist();//이건 항상 0 리턴 - 활용 불가능
        }
        return true;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {//모든 빈이 생성되고 의존성이 주입된 후 실행됨
        setUp();

    }
}
