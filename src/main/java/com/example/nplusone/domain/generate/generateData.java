package com.example.nplusone.domain.generate;

import com.example.nplusone.domain.Member;
import com.example.nplusone.domain.Team;
import com.example.nplusone.domain.repository.MemberRepository;
import com.example.nplusone.domain.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Repository
@RequiredArgsConstructor
public class generateData {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    @PostConstruct
    private void generateEx() {
        Team team = new Team(1L, "gsm");

        Member member1 = new Member(1L, "member1", team);
        Member member2 = new Member(2L, "member2", team);
        Member member3 = new Member(3L, "member3", team);
        Member member4 = new Member(4L, "member4", team);
        Member member5 = new Member(5L, "member5", team);
        Member member6 = new Member(6L, "member6", team);
        Member member7 = new Member(7L, "member7", team);
        Member member8 = new Member(8L, "member8", team);
        Member member9 = new Member(9L, "member9", team);
        Member member10 = new Member(10L, "member10", team);

    }

}
