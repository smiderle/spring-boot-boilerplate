package br.com.smiderle.rank.repository;

import br.com.smiderle.rank.domain.UsuarioPerfilFacebook;
import br.com.smiderle.rank.query.UsuarioPerfilFacebookQuery;
import br.com.smiderle.rank.repository.metadata.UsuarioPerfilFacebook_;
import br.com.smiderle.rank.util.EnumUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ladairsmiderle on 12/05/2016.
 */
@Repository
public class UsuarioPerfilFacebookRepository extends AbstractRepository {

    public void insert( final UsuarioPerfilFacebook usuarioPerfilFacebook ) {

        Map< String, Object > parametros = new HashMap< String, Object >() {
            {
                put( UsuarioPerfilFacebook_.idPerfil, usuarioPerfilFacebook.getIdPerfil() );
                put( UsuarioPerfilFacebook_.dsNome, usuarioPerfilFacebook.getDsNome() );
                put( UsuarioPerfilFacebook_.dsPrimeiroNome, usuarioPerfilFacebook.getDsPrimeiroNome() );
                put( UsuarioPerfilFacebook_.dsUltimoNome, usuarioPerfilFacebook.getDsUltimoNome() );
                put( UsuarioPerfilFacebook_.dsLinkPerfil, usuarioPerfilFacebook.getDsLinkPerfil() );
                put( UsuarioPerfilFacebook_.dsEmail, usuarioPerfilFacebook.getDsEmail() );
                put( UsuarioPerfilFacebook_.dsLocale, usuarioPerfilFacebook.getDsLocale() );
                put( UsuarioPerfilFacebook_.tpGenero, EnumUtils.ordinal( usuarioPerfilFacebook.getTpGenero() ) );
            }
        };

        Long id = repositoryTemplate.insert( UsuarioPerfilFacebookQuery.insert, parametros, UsuarioPerfilFacebook_.idUsuarioPerfilFacebook );

        usuarioPerfilFacebook.setIdUsuarioPerfilFacebook( id );

    }
}
