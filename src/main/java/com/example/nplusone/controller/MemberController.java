package com.example.nplusone.controller;

import com.example.nplusone.domain.member.Member;
import com.example.nplusone.domain.member.repository.MemberRepository;
import com.example.nplusone.resolution.fetch_join.data_jpa.DataJpaMemberRepository;
import com.example.nplusone.resolution.fetch_join.querydsl.QueryDslMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberController {

    private final MemberRepository memberRepository;
    private final DataJpaMemberRepository dataJpaMemberRepository;
    private final QueryDslMemberRepository queryDslMemberRepository;

    /**
     * N+1 예제
     */
    @GetMapping("/get-members-team")
    public void getMembersTeam() {
        List<Member> members = memberRepository.findAll();

        for (Member member : members) {
            System.out.println("member.getMemberName() = " + member.getMemberName()); // 단순 member를 조회하기 때문에 쿼리 1개발생
            System.out.println("member.getTeam().getTeamName() = " + member.getTeam().getTeamName());
            // 지연로딩으로 인해 member의 Team은 프록시로 불러와 지는데
            // member의 team에 접근을 하면 프록시 객체가 아닌 db에서 다시 불러와진다
            // 하지만 위 코드를 보면 member 1명마다 그 member의 team을 조회하기 때문에 member한명당 한번의 쿼리가 발생한다 이를 N+1이라 한다
            // 이를 해결하기 위해선 member들의 team을 전체조회 하는게 해결방법이다
        }
    }


    /**
     * Data JPA로 해결하기 (fetch join)
     */
    @GetMapping("/get-members-team/data-jpa")
    public void getMembersTeamDataJpa() {
        List<Member> members = dataJpaMemberRepository.findAllWithDataJpa();

        for (Member member : members) {
            System.out.println("member.getMemberName() = " + member.getMemberName());
            System.out.println("member.getTeam().getTeamName() = " + member.getTeam().getTeamName());
        }
    }


    /**
     * Querydsl로 해결하기 (fetch join)
     */
    @GetMapping("/get-members-team/querydsl")
    public void getMembersTeamQuerydsl() {
        List<Member> members = queryDslMemberRepository.findAllWithQueryDsl();

        for (Member member : members) {
            System.out.println("member.getMemberName() = " + member.getMemberName());
            System.out.println("member.getTeam().getTeamName() = " + member.getTeam().getTeamName());
        }
    }

}
