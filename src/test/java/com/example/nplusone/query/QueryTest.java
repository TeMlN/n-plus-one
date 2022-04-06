package com.example.nplusone.query;

import com.example.nplusone.domain.member.Member;
import com.example.nplusone.domain.member.repository.MemberRepository;
import com.example.nplusone.domain.team.Team;
import com.example.nplusone.domain.team.repository.TeamRepository;
import org.apache.logging.slf4j.SLF4JLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.logging.Logger;

@SpringBootTest
@Transactional
public class QueryTest {

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager em;

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
