package com.game.controller;

import com.game.domain.Weapons;
import com.game.repository.WeaponsReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dev/creator/weapons")
public class WeaponsCreatorDev {
    @Autowired
    private WeaponsReporitory weaponsReporitory;

    @GetMapping
    public String exibirFormulario(Model model) {
        model.addAttribute("weapons", new Weapons());
        return "weapons-creator-dev";
    }

    @PostMapping("/salvar")
    public String salvarUsuario(@ModelAttribute Usuario usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/usuarios";
    }
}
