package com.game.controller;

import com.game.domain.Weapons;
import com.game.enums.EAttribute;
import com.game.repository.WeaponsReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dev/creator/weapons")
public class WeaponsCreatorDev {
    @Autowired
    private WeaponsReporitory weaponsReporitory;

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("showWeapons", weaponsReporitory.findAll());

        model.addAttribute("newWeapon", new Weapons());

        model.addAttribute("allAttributes", EAttribute.values());

        return "weapons-creator-dev";
    }

    @PostMapping("/save")
    public String saveWeapon(@ModelAttribute("newWeapon") Weapons weapon) {
        weaponsReporitory.save(weapon);
        return "redirect:/dev/creator/weapons";
    }
}
