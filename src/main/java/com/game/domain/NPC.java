package com.game.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "tb_npcs")
public class NPC implements HasAttributes{
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="npc_seq")
    @SequenceGenerator(name="npc_seq", sequenceName="sq_npc", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "level", nullable = false)
    private int level;

    @Column(name = "hp", nullable = false)
    private Long hp = 10L;

    @Column(name = "strength", nullable = false)
    private int strength = 10;

    @Column(name = "dexterity", nullable = false)
    private int dexterity = 10;

    @Column(name = "contitution", nullable = false)
    private int contitution = 10;

    @Column(name = "intelligence", nullable = false)
    private int intelligence = 10;

    @Column(name = "widsom", nullable = false)
    private int widsom = 10;

    @Column(name = "charisma", nullable = false)
    private int charisma = 10;

    @Column(name = "armor", nullable = false)
    private int armor = 10;

    @ManyToMany
    @JoinTable(
            name = "npc_weapons",
            joinColumns = @JoinColumn(name = "npc_id"),
            inverseJoinColumns = @JoinColumn(name = "weapons_id")
    )
    private List<Weapons> weapons;

    @Override
    public int getConstitution() {
        return contitution;
    }

    @Override
    public int getWisdom() {
        return widsom;
    }
}
