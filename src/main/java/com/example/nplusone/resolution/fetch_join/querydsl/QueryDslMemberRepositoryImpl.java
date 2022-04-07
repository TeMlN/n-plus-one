package com.example.nplusone.resolution.fetch_join.querydsl;

import com.example.nplusone.domain.member.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.nplusone.domain.member.QMember.*;
import static com.example.nplusone.domain.team.QTeam.*;

@RequiredArgsConstructor
public class QueryDslMemberRepositoryImpl implements QueryDslMemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Member> findAllWithQueryDsl() {
        return queryFactory.selectFrom(member)
                .leftJoin(member.team, team)
                .fetchJoin()
                .fetch();
    }
}
