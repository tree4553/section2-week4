package com.codestates.section2week4.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// AutoDependencyConfig의 @ComponentScan에서 MemberRepository를 Bean으로 등록하기 위해 @Component 입력
@Component
public class MemberRepository {

    private static Map<Long, Member> members = new HashMap<>();

    public void postMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    public Member getMember(Long memberId) {
        return members.get(memberId);
    }

    public void deleteMember(Long memberId) {
        members.remove(memberId);
    }
}
