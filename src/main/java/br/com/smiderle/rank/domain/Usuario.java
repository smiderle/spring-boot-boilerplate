package br.com.smiderle.rank.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by ladairsmiderle on 14/05/2016.
 */
@Getter
@Setter
public class Usuario {

    private Long idUsuario;

    private UsuarioPerfil usuarioPerfil;
}
