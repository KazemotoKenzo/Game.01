package com.game.repository;

import com.game.domain.NPC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NpcRepository extends JpaRepository<NPC, Long> {
}
