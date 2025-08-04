package com.game.entity;

import com.game.domain.NPC;

public interface IEntity {
    public boolean checkHit(NPC takeDamage, NPC dealDamage);

    public void damageTaken(NPC takeDamage, NPC dealDamage);

    public boolean isDead(NPC entity);
}
