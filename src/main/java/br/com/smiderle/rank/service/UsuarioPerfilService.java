package br.com.smiderle.rank.service;

import br.com.smiderle.rank.domain.UsuarioPerfil;
import br.com.smiderle.rank.repository.UsuarioPerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ladairsmiderle on 14/05/2016.
 */
@Service
@Transactional
public class UsuarioPerfilService {
    @Autowired
    UsuarioPerfilRepository repository;

    @Autowired
    UsuarioPerfilFacebookService usuarioPerfilFacebookService;

    public void save( UsuarioPerfil usuarioPerfil ) {

        usuarioPerfilFacebookService.save( usuarioPerfil.getUsuarioPerfilFacebook() );
        repository.insert( usuarioPerfil );

    }
}
