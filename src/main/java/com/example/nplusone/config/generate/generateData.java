package com.example.nplusone.config.generate;

import com.example.nplusone.domain.member.Member;
import com.example.nplusone.domain.team.Team;
import com.example.nplusone.domain.member.repository.MemberRepository;
import com.example.nplusone.domain.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Component
@Repository
@RequiredArgsConstructor
public class generateData {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;
    private final EntityManager em;

    @PostConstruct
    private void generateEx() {

        Team teamA = Team.builder()
                .id(1L)
                .teamName("teamA")
                .build();

        Team teamB = Team.builder()
                .id(2L)
                .teamName("teamB")
                .build();

        Team teamC = Team.builder()
                .id(3L)
                .teamName("teamC")
                .build();

        Team teamD = Team.builder()
                .id(4L)
                .teamName("teamD")
                .build();

        Team teamE = Team.builder()
                .id(5L)
                .teamName("teamE")
                .build();

        teamRepository.save(teamA);
        teamRepository.save(teamB);
        teamRepository.save(teamC);
        teamRepository.save(teamD);
        teamRepository.save(teamE);


        memberRepository.save(
                Member.builder()
                        .id(1L)
                        .team(teamA)
                        .memberName("member1")
                        .build()
        );

        memberRepository.save(
                Member.builder()
                        .id(2L)
                        .team(teamB)
                        .memberName("member2")
                        .build()
        );

        memberRepository.save(
                Member.builder()
                        .id(3L)
                        .team(teamC)
                        .memberName("member3")
                        .build()
        );

        memberRepository.save(
                Member.builder()
                        .id(4L)
                        .team(teamD)
                        .memberName("member4")
                        .build()
        );

        memberRepository.save(
                Member.builder()
                        .id(5L)
                        .team(teamE)
                        .memberName("member5")
                        .build()
        );

        em.clear();
    }

}
