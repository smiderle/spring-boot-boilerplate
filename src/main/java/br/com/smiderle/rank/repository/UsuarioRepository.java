package br.com.smiderle.rank.repository;

import br.com.smiderle.rank.domain.Usuario;
import br.com.smiderle.rank.repository.metadata.Usuario_;
import br.com.smiderle.rank.query.UsuarioQuery;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ladairsmiderle on 12/05/2016.
 */
@Repository
public class UsuarioRepository extends AbstractRepository {

    public void insert(final Usuario usuario) {

        Map<String, Object> parametros = new HashMap<String, Object>() {
            {
                put(Usuario_.idUsuarioPerfil, usuario.getUsuarioPerfil().getIdUsuarioPerfil());
            }
        };

        Long id = repositoryTemplate.insert(UsuarioQuery.insert, parametros, Usuario_.idUsuario);

        usuario.setIdUsuario(id);

    }

}
