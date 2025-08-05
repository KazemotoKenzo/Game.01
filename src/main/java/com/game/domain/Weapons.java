package com.game.domain;

import com.game.enums.EAttribute;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "tb_weapons")
public class Weapons {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="weapon_seq")
    @SequenceGenerator(name="weapon_seq", sequenceName="sq_weapon", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @ManyToMany(mappedBy = "weapons")
    private List<NPC> npcs;

    @Enumerated(EnumType.STRING)
    @Column(name = "scaling_attribute")
    private EAttribute scale;

    @Column(name = "bonus", nullable = false)
    private int bonus = 2;

    @Column(name = "numberOfDice", nullable = false)
    private int numberOfDice = 1;

    @Column(name = "diceFaces", nullable = false)
    private int diceFaces = 4;
}
