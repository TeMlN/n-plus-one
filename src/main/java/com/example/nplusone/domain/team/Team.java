package com.example.nplusone.domain.team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter @Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
public class Team {

    @Column(name = "team_id")
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "team_name")
    private String teamName;
}
