package com.example.nplusone.domain.member;

import com.example.nplusone.domain.team.Team;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;
import static lombok.AccessLevel.*;

@Entity
@Getter @Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
public class Member {

    @Column(name = "member_id")
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "member_name")
    private String memberName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;
}
