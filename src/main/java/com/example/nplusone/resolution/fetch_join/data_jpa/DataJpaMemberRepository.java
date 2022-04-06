package com.example.nplusone.resolution.fetch_join.data_jpa;

import com.example.nplusone.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DataJpaMemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m join fetch m.team")
    List<Member> findAllWithDataJpa();
}
