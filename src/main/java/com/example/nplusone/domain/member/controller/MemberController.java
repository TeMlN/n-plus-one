package com.example.nplusone.domain.team.controller;

import com.example.nplusone.domain.member.Member;
import com.example.nplusone.domain.member.repository.MemberRepository;
import com.example.nplusone.domain.team.Team;
import com.example.nplusone.domain.team.repository.TeamRepository;
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

    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;

    @GetMapping("/get-members-team")
    public void getMembersTeam() {
        List<Member> members = memberRepository.findAll();

        for (Member member : members) {
            System.out.println("member.getMemberName() = " + member.getMemberName());
            System.out.println("member.getTeam().getTeamName() = " + member.getTeam().getTeamName());
        }
    }

}
