package com.game.domain;

import com.game.enums.EAttribute;
import jakarta.persistence.*;

import java.util.List;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NPC> getNpcs() {
        return npcs;
    }

    public void setNpcs(List<NPC> npcs) {
        this.npcs = npcs;
    }

    public EAttribute getScale() {
        return scale;
    }

    public void setScale(EAttribute scale) {
        this.scale = scale;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getNumberOfDice() {
        return numberOfDice;
    }

    public void setNumberOfDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public int getDiceFaces() {
        return diceFaces;
    }

    public void setDiceFaces(int diceFaces) {
        this.diceFaces = diceFaces;
    }
}
