package br.com.smiderle.rank.service;

import br.com.smiderle.rank.domain.UsuarioPerfilFacebook;
import br.com.smiderle.rank.repository.UsuarioPerfilFacebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ladairsmiderle on 12/05/2016.
 */
@Service
@Transactional
public class UsuarioPerfilFacebookService {

    @Autowired
    UsuarioPerfilFacebookRepository repository;

    public void save( UsuarioPerfilFacebook usuarioPerfilFacebook ) {

        repository.insert( usuarioPerfilFacebook );

    }

}
