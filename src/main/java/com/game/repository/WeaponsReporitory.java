package com.game.repository;

import com.game.domain.Weapons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponsReporitory extends JpaRepository<Weapons, Long> {
}
