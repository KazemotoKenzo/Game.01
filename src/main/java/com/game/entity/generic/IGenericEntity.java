package com.game.entity.generic;

import com.game.domain.NPC;
import com.game.domain.Weapons;

public interface IGenericEntity {
    public boolean rollAttack(NPC takeDamage, NPC dealDamage, Long weaponsId);

    public int rollDamage(NPC dealDamage, Long weaponsId, boolean criticalHit);

    public boolean checkHit(NPC takeDamage);

    public void damageTaken(NPC takeDamage, NPC dealDamage, Long weaponsId);

    public boolean isDead(NPC entity);
}
