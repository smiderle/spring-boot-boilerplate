package br.com.smiderle.rank.query

/**
 * Created by ladairsmiderle on 14/05/2016.
 */
class UsuarioQuery {

    public static String insert = """
        INSERT INTO USUARIO (
            ID_USUARIO_PERFIL )
        VALUES (
            :id_usuario_perfil )
    """
}
