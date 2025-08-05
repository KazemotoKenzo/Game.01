package com.game.entity.generic;

import com.game.domain.NPC;
import com.game.domain.Weapons;

public interface IGenericEntity {
    public void weponEquipped(NPC npcWeapon, Long weaponId);

    public int rollAttack(NPC dealDamage);

    public int rollDamage(NPC dealDamage);

    public boolean checkHit(NPC takeDamage, int attack);

    public void damageTaken(NPC takeDamage, int damage);

    public boolean isDead(NPC entity);
}
