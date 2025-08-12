package com.game.domain;

import jakarta.persistence.*;

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
    private int level = 1;

    @Column(name = "hp", nullable = false)
    private int hp = 10;

    @Column(name = "strength", nullable = false)
    private int strength = 10;

    @Column(name = "dexterity", nullable = false)
    private int dexterity = 10;

    @Column(name = "constitution", nullable = false)
    private int constitution = 10;

    @Column(name = "intelligence", nullable = false)
    private int intelligence = 10;

    @Column(name = "wisdom", nullable = false)
    private int wisdom = 10;

    @Column(name = "charisma", nullable = false)
    private int charisma = 10;

    @ManyToOne
    @JoinColumn(name = "weapon_id")
    private Weapons weapon;

    @Column(name = "armor", nullable = false)
    private int armor = 10;

    public void takeDamage(int damage){
        if (damage > 0){
            this.hp -= damage;
        }
    }

    @Transient
    public boolean isDead() {
        if(this.hp <= 0){
            this.hp = 0;
            return true;
        }
        return false;
    }

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    @Override
    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int contitution) {
        this.constitution = contitution;
    }

    @Override
    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int widsom) {
        this.wisdom = widsom;
    }

    @Override
    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public Weapons getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }
}
