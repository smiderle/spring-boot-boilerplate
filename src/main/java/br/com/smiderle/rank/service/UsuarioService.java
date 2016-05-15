package br.com.smiderle.rank.service;

import br.com.smiderle.rank.domain.Usuario;
import br.com.smiderle.rank.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ladairsmiderle on 14/05/2016.
 */
@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    UsuarioPerfilService usuarioPerfilService;

    public void save( Usuario usuario ) {

        usuarioPerfilService.save( usuario.getUsuarioPerfil() );
        repository.insert( usuario );

    }
}
