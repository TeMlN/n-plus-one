package com.example.nplusone.resolution.fetch_join.querydsl;

import com.example.nplusone.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryDslMemberRepository extends JpaRepository<Member, Long>, QueryDslMemberRepositoryCustom{
}
