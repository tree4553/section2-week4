package com.codestates.section2week4;

import com.codestates.section2week4.member.MemberService;
import com.codestates.section2week4.singleton.SingletonService;

public class SingletonTest {
    static DependencyConfig dependencyConfig = new DependencyConfig();

    static MemberService memberService1 = dependencyConfig.memberService();
    static MemberService memberService2 = dependencyConfig.memberService();

    static SingletonService singletonService1 = SingletonService.getInstance();
    static SingletonService singletonService2 = SingletonService.getInstance();

    public static void main(String[] args) {
        // 같은 memberService 이지만 주소값이 다르다.
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // 같은 주소값이 출력된다.
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);
    }
}
