package com.game;

import com.game.domain.NPC;
import com.game.domain.Weapons;
import com.game.domain.service.CombatService;
import com.game.enums.EAttribute;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class CombatTests {
	@Mock
	private NPC mockAttacker;
	@Mock
	private NPC mockTarget;
	@Mock
	private Weapons mockWeapon;

	private CombatService combateService;

	@BeforeEach
	void setUP(){
		this.combateService = new CombatService();
	}

	@Test
	void rollAttack_retorna20ativarCritico(){
		try (MockedStatic<ThreadLocalRandom> mockedRandom = Mockito.mockStatic(ThreadLocalRandom.class)){
			ThreadLocalRandom randomMock = Mockito.mock(ThreadLocalRandom.class);

			mockedRandom.when(ThreadLocalRandom::current).thenReturn(randomMock);

			when(randomMock.nextInt(anyInt(), anyInt())).thenReturn(20);

			when(mockAttacker.getWeapon()).thenReturn(mockWeapon);
			when(mockWeapon.getBonus()).thenReturn(5);

			int attackResult = combateService.rollAttack(mockAttacker);

			assertThat(attackResult).isEqualTo(20);
			assertThat(combateService.isCriticalHit()).isTrue();
		}
	}
}
