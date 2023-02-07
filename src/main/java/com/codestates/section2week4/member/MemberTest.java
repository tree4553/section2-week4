package com.codestates.section2week4.member;

import com.codestates.section2week4.DependencyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberTest {
    public static void main(String[] args) {
        // 직접 DependencyConfig를 생성하여 주입하는 방식
//        DependencyConfig dependencyConfig = new DependencyConfig();
//        MemberService memberService = dependencyConfig.memberService();

        // 스프링 컨테이너에 등록된 빈을 가져오는 방식
        ApplicationContext ac = new AnnotationConfigApplicationContext(DependencyConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member = new Member(0L, "ljc@naver.com", "ljc", "010-1234-5678");
        memberService.createMember(member);

        Member currentMember = memberService.getMember(0L);

        System.out.println("회원 가입한 유저 : " + member.getName());
        System.out.println("현재 첫번째 유저 : " + currentMember.getName());

        if(member.getName().equals(currentMember.getName())) {
            System.out.println("새롭게 가입한 사용자와 현재 사용자가 같습니다.");
        }

        memberService.deleteMember(0L);

        if(memberService.getMember(0L) == null) {
            System.out.println("회원 삭제가 정상적으로 완료되었습니다.");
        }
    }
}
