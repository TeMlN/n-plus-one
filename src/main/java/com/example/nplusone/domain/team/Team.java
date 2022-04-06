package com.example.nplusone.domain.team;

import com.example.nplusone.domain.member.Member;
import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter @Builder @Setter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
public class Team {

    @Column(name = "team_id")
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "team_name")
    private String teamName;

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();
}
