package com.example.nplusone.domain.repository;

import com.example.nplusone.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
