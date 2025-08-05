package com.game.entity.generic;

import com.game.domain.HasAttributes;
import com.game.domain.NPC;
import com.game.domain.Weapons;
import com.game.enums.EAttribute;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class GenericEntity implements IGenericEntity{
    public boolean criticalHit = false;

    public static int rollDice(int sides){
        return ThreadLocalRandom.current().nextInt(1, sides + 1);
    }

    public static int roll20(){
        return rollDice(20);
    }

    public int convertBonus(int attribute){
        return attribute / 2 - 5;
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
    public boolean rollAttack(NPC takeDamage, NPC dealDamage, Long weaponsId) {
        int dice = roll20();
        int attack = dealDamage.getWeapons().stream().filter(weapon -> weapon.getId().equals(weaponsId)).findAny().map(Weapons::getBonus).orElse(0);;
        int armor = takeDamage.getArmor();

        if(dice == 20){
            criticalHit = true;
            System.out.println("Acerto Crítico!");
            return true;
        } else if (dice + attack >= armor) {
            System.out.println("O ataque acertou o alvo!");
            return true;
        }

        System.out.println("O ataque errou!");
        return false;
    }

    @Override
    public int rollDamage(NPC dealDamage, Long weaponsId, boolean criticalHit) {
        int numberOfDice = dealDamage.getWeapons().stream().filter(weapon -> weapon.getId().equals(weaponsId)).findAny().map(Weapons::getNumberOfDice).orElse(1);
        int diceFaces = dealDamage.getWeapons().stream().filter(weapon -> weapon.getId().equals(weaponsId)).findAny().map(Weapons::getDiceFaces).orElse(4);
        int weaponDamageBonus = dealDamage.getWeapons().stream().filter(weapon -> weapon.getId().equals(weaponsId)).findAny().map(Weapons::getBonus).orElse(2);
        EAttribute scale = dealDamage.getWeapons().stream().filter(weapon -> weapon.getId().equals(weaponsId)).findAny().map(Weapons::getScale).orElse(null);

        int scaleBonus = getAttributeValue(dealDamage, scale);
        int dice = 0;

        for(int i = 1; i <= numberOfDice; i++){
            dice += rollDice(diceFaces);
        }

        return dice + weaponDamageBonus + convertBonus(scaleBonus);
    }

    @Override
    public boolean checkHit(NPC takeDamage) {
        return false;
    }

    @Override
    public void damageTaken(NPC takeDamage, NPC dealDamage, Long weaponsId) {

    }

    @Override
    public boolean isDead(NPC entity) {
        return false;
    }
}
