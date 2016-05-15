package br.com.smiderle.rank.domain;

import br.com.smiderle.rank.enumeration.TipoGenero;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by ladairsmiderle on 12/05/2016.
 */
@Setter
@Getter
public class UsuarioPerfilFacebook {

    private Long idUsuarioPerfilFacebook;
    private Integer idPerfil;
    private String dsNome;
    private String dsPrimeiroNome;
    private String dsUltimoNome;
    private String dsLinkPerfil;
    private String dsEmail;
    private String dsLocale;
    private TipoGenero tpGenero;

}
