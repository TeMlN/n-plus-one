package com.example.nplusone.domain;

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
    @JoinColumn(name = "team")
    private Team team;
}
