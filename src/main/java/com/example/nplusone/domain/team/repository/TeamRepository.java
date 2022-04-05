package com.example.nplusone.domain.team.repository;

import com.example.nplusone.domain.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
