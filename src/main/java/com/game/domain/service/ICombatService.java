package com.game.domain.service;

import com.game.domain.NPC;

public interface ICombatService {
    public void weponEquipped(NPC npcWeapon);

    public int rollAttack(NPC dealDamage);

    public int rollDamage(NPC dealDamage);

    public boolean checkHit(NPC takeDamage, int attack);

    public void damageTaken(NPC takeDamage, int damage);

    public boolean isDead(NPC entity);
}
