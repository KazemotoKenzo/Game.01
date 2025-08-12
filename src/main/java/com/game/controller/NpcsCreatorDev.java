package com.game.controller;

import com.game.domain.NPC;
import com.game.domain.Weapons;
import com.game.enums.EAttribute;
import com.game.repository.NpcRepository;
import com.game.repository.WeaponsReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dev/creator/npcs")
public class NpcsCreatorDev {
    @Autowired
    private NpcRepository npcRepository;

    @Autowired
    private WeaponsReporitory weaponsRepository;

    @GetMapping("/npcs/create")
    public String createNpcForm(Model model) {
        model.addAttribute("weapons", weaponsRepository.findAll());
        return "npcs-creator-dev";
    }

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("showNpcs", npcRepository.findAll());

        model.addAttribute("newNpc", new NPC());

        model.addAttribute("weapons", weaponsRepository.findAll());

        return "npcs-creator-dev";
    }

    @PostMapping("/save")
    public String saveNpc(@ModelAttribute("newNpc") NPC npc, @RequestParam("weaponId") Long weaponId) {
        Weapons weapon = weaponsRepository.findById(weaponId)
                .orElse(null);
        npc.setWeapon(weapon);

        npcRepository.save(npc);
        return "redirect:/dev/creator/npcs";
    }
}
