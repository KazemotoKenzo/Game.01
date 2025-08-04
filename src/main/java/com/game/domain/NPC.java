package com.game.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "tb_npc")
public class NPC {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="npc_seq")
    @SequenceGenerator(name="npc_seq", sequenceName="sq_npc", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "hp", nullable = false)
    private Long hp = 10L;

    @Column(name = "strength", nullable = false)
    private int strength = 0;

    @Column(name = "dexterity", nullable = false)
    private int dexterity = 0;

    @Column(name = "contitution", nullable = false)
    private int contitution = 0;

    @Column(name = "intelligence", nullable = false)
    private int intelligence = 0;

    @Column(name = "widsom", nullable = false)
    private int widsom = 0;

    @Column(name = "charisma", nullable = false)
    private int charisma = 0;

    @Column(name = "armor", nullable = false)
    private int armor = 10;
}
