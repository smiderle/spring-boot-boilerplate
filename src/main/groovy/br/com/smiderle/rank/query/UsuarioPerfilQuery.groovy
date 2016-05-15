package br.com.smiderle.rank.query

/**
 * Created by ladairsmiderle on 14/05/2016.
 */
class UsuarioPerfilQuery {

    public static String insert = """
        INSERT INTO USUARIO_PERFIL (
            ID_USUARIO_PERFIL_FACEBOOK )
        VALUES (
            :id_usuario_perfil_facebook )
    """
}
