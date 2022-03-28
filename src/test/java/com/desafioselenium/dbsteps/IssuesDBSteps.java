package com.desafioselenium.dbsteps;

import com.desafioselenium.utils.DBUtils;
import com.desafioselenium.utils.Utils;

public class IssuesDBSteps {

    private static String queriesPath = "src/test/java/com/desafioselenium/queries/issuesqueries/";

    public static String retornaArquivo(String arquivo){
        String query = Utils.getFileContent(queriesPath + "buscaArquivo.sql").replace("$nomeArquivo", arquivo);

        return DBUtils.getQueryResult(query).get(0);
    }
}
