package com.example.nplusone.resolution.fetch_join.querydsl;

import com.example.nplusone.domain.member.Member;

import java.util.List;

public interface QueryDslMemberRepositoryCustom {

    List<Member> findAllWithQueryDsl();
}
