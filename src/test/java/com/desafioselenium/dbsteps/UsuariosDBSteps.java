package com.desafioselenium.dbsteps;

import com.desafioselenium.utils.DBUtils;
import com.desafioselenium.utils.Utils;

public class UsuariosDBSteps {

    private static String queriesPath = "src/test/java/com/desafioselenium/queries/usuariosqueries/";

    public static String retornaSenhaDoUsuarioDB(String usuario){
        String query = Utils.getFileContent(queriesPath + "retornaSenhaDoUsuario.sql").replace("$usuario", usuario);

        return DBUtils.getQueryResult(query).get(0);
    }
}
