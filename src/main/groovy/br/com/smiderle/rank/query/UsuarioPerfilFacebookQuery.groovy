package br.com.smiderle.rank.query

/**
 * Created by ladairsmiderle on 14/05/2016.
 */
class UsuarioPerfilFacebookQuery {


    public static String insert = """
        INSERT INTO USUARIO_PERFIL_FACEBOOK (
            ID_PERFIL,
            DS_NOME,
            DS_PRIMEIRO_NOME,
            DS_ULTIMO_NOME,
            DS_LINK_PERFIL,
            DS_EMAIL,
            DS_LOCALE,
            TP_GENERO )
        VALUES (
            :id_perfil,
            :ds_nome ,
            :ds_primeiro_nome,
            :ds_ultimo_nome,
            :ds_link_perfil ,
            :ds_email,
            :ds_locale,
            :tp_genero )
    """
}
