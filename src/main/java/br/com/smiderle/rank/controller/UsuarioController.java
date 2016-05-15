package br.com.smiderle.rank.controller;

import br.com.smiderle.rank.domain.Usuario;
import br.com.smiderle.rank.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ladairsmiderle on 12/05/2016.
 */
@RestController()
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(method = RequestMethod.POST)
    public Usuario save(@RequestBody Usuario usuario) {
        usuarioService.save(usuario);
        return usuario;
    }

}