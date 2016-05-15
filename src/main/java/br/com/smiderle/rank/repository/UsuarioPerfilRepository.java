package br.com.smiderle.rank.repository;

import br.com.smiderle.rank.domain.UsuarioPerfil;
import br.com.smiderle.rank.repository.metadata.UsuarioPerfil_;
import br.com.smiderle.rank.query.UsuarioPerfilQuery;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ladairsmiderle on 12/05/2016.
 */
@Repository
public class UsuarioPerfilRepository extends AbstractRepository {

    public void insert(final UsuarioPerfil usuarioPerfil) {

        Map<String, Object> parametros = new HashMap<String, Object>() {
            {
                put(UsuarioPerfil_.idUsuarioPerfilFacebook, usuarioPerfil.getUsuarioPerfilFacebook().getIdUsuarioPerfilFacebook());
            }
        };

        Long id = repositoryTemplate.insert(UsuarioPerfilQuery.insert, parametros, UsuarioPerfil_.idUsuarioPerfil);

        usuarioPerfil.setIdUsuarioPerfil(id);

    }

}
