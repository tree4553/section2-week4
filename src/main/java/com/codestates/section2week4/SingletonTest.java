package com.codestates.section2week4;

import com.codestates.section2week4.member.MemberService;
import com.codestates.section2week4.singleton.SingletonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {
    static DependencyConfig dependencyConfig = new DependencyConfig();

//    static MemberService memberService1 = dependencyConfig.memberService();
//    static MemberService memberService2 = dependencyConfig.memberService();

    // Java에서 객체를 한개만 생성하여 공유하는 방식으로 객체 생성
    static SingletonService singletonService1 = SingletonService.getInstance();
    static SingletonService singletonService2 = SingletonService.getInstance();

    // Spring의 Bean을 이용한 객체 생성
    static AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DependencyConfig.class);
    static MemberService memberService3 = ac.getBean("memberService", MemberService.class);
    static MemberService memberService4 = ac.getBean("memberService", MemberService.class);

    public static void main(String[] args) {
        // 같은 memberService 이지만 주소값이 다르다.
//        System.out.println("memberService1 = " + memberService1);
//        System.out.println("memberService2 = " + memberService2);

        // 같은 주소값이 출력된다.
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        // 같은 주소값이 출력된다.
        System.out.println("memberService3 = " + memberService3);
        System.out.println("memberService4 = " + memberService4);
    }
}
