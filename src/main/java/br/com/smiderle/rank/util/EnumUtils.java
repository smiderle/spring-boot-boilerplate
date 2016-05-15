package br.com.smiderle.rank.util;

/**
 * Created by ladairsmiderle on 15/05/2016.
 */
public class EnumUtils {

    /**
     * Retorna o ordinal do enum, caso esse enum não seja nulo.
     *
     * @param enumeration
     * @return
     */
    public static Integer ordinal( Enum enumeration ) {

        if ( enumeration != null ) {
            return enumeration.ordinal();
        }

        return null;

    }
}
