package com.example.nplusone.domain.member.repository;

import com.example.nplusone.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
