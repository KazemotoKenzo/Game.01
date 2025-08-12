package com.game.entity.generic;

import com.game.domain.HasAttributes;
import com.game.domain.NPC;
import com.game.domain.Weapons;
import com.game.enums.EAttribute;

import java.util.concurrent.ThreadLocalRandom;

public class GenericEntity implements IGenericEntity{
    public GenericEntity(NPC npcWeapon, Long weaponId) {
        this.criticalHit = false;
        //this.weaponEquipped = npcWeapon.getWeapons().stream().filter(weapon -> weapon.getId().equals(weaponId)).findAny().orElse(null);
    }

    private Weapons weaponEquipped;

    private boolean criticalHit;

    public static int rollDice(int sides){
        return ThreadLocalRandom.current().nextInt(1, sides + 1);
    }

    public static int roll20(){
        return rollDice(20);
    }

    public int convertBonus(int attribute){
        return attribute / 2 - 5;
    }

    @Override
    public void weponEquipped(NPC npcWeapon, Long weaponId) {
        //this.weaponEquipped = npcWeapon.getWeapons().stream().filter(weapon -> weapon.getId().equals(weaponId)).findAny().orElse(null);
        System.out.println(this.weaponEquipped.getName() + "Está equipado");
    }

    public static int getAttributeValue(HasAttributes entity, EAttribute attribute) {
        switch (attribute) {
            case STRENGTH: return entity.getStrength();
            case DEXTERITY: return entity.getDexterity();
            case CONSTITUTION: return entity.getConstitution();
            case INTELLIGENCE: return entity.getIntelligence();
            case WISDOM: return entity.getWisdom();
            case CHARISMA: return entity.getCharisma();
            default: throw new IllegalArgumentException("Atributo inválido: " + attribute);
        }
    }

    @Override
    public int rollAttack(NPC dealDamage) {
        int dice = roll20();
        int attack = this.weaponEquipped.getBonus();

        if(dice == 20){
            System.out.println("Crítico");
            this.criticalHit = true;
            return 20;
        }

        return dice + attack;
    }

    @Override
    public int rollDamage(NPC dealDamage) {
        int numberOfDice = this.weaponEquipped.getNumberOfDice();
        int diceFaces = this.weaponEquipped.getDiceFaces();
        EAttribute scale = this.weaponEquipped.getScale();
        int scaleBonus = getAttributeValue(dealDamage, scale);

        int diceTotal = 0;

        for(int i = 1; i <= numberOfDice; i++){
            diceTotal += rollDice(diceFaces);
        }

        if(this.criticalHit){
            diceTotal *= 2;
            this.criticalHit = false;
        }

        return diceTotal + convertBonus(scaleBonus);
    }

    @Override
    public boolean checkHit(NPC takeDamage, int attack) {
        int armor = takeDamage.getArmor();

        if(criticalHit){
            System.out.println("Acerto Crítico!");
            return true;
        } else if (attack >= armor) {
            System.out.println("O ataque acertou o alvo!");
            return true;
        }

        System.out.println("O ataque errou!");
        return false;
    }

    @Override
    public void damageTaken(NPC takeDamage, int damage) {
        takeDamage.setHp(takeDamage.getHp() - damage);
    }

    @Override
    public boolean isDead(NPC entity) {
        return entity.getHp() <= 0;
    }
}
