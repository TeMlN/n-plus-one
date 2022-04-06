package com.example.nplusone.query;

import com.example.nplusone.domain.member.Member;
import com.example.nplusone.domain.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class QueryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void findMemberLazy() throws Exception {
        System.out.println("==========start==========");
        List<Member> members = memberRepository.findAll();

        for (Member member : members) {
            System.out.println("member = " + member.getMemberName());
            System.out.println("member.getTeam().getTeamName() = " + member.getTeam().getTeamName());
        }
        System.out.println("==========finish==========");
        }
}
