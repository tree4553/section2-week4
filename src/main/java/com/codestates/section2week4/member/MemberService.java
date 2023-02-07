package com.codestates.section2week4.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// AutoDependencyConfig에서 @ComponentScan으로 MemberService를 Bean으로 등록 할 수 있도록 @Component 입력
@Component
public class MemberService {

    // DI 미적용
    //private final MemberRepository memberRepository = new MemberRepository();

    // DI 적용
    private final MemberRepository memberRepository;

    // MemberRepository를 의존하는 MemberService 클래스의 Bean 등록과 의존관계도를 자동으로 주입하는 @Autowired 입력
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void createMember(Member member) {
        memberRepository.postMember(member);
    }

    public Member getMember(Long memberId) {
        return memberRepository.getMember(memberId);
    }

    public void deleteMember(Long memberId) {
        memberRepository.deleteMember(memberId);
    }
}
