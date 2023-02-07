package com.codestates.section2week4;

import com.codestates.section2week4.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    // TestBean 클래스에는 현재 Member 클래스의 Bean이 없다.
    // 없는 Bean을 주입하려 하는 경우 NoSuchBeanDefinitionException이 발생한다.
    static class TestBean {

        // Member Bean이 없어서 에러가 발생하는 케이스
//        @Autowired
//        public void setNoBean0(Member noBean0) {
//            System.out.println("noBean0 = " + noBean0);
//        }

        // required 옵션을 false로 입력하면 주입할 Bean이 없는 경우 실행을 하지 않는다.
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        // @Nullable 옵션을 사용하면 주입할 Bean이 존재하지 않는 경우 null을 넣어준다.
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        // Optional 옵션을 사용하면 주입할 대상이 없을때 Optional.empty가 입력된다.
        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
