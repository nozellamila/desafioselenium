package com.desafioselenium.utils;

import com.desafioselenium.GlobalParameters;

import java.sql.*;

import java.util.ArrayList;

public class DBUtils {

    public static ArrayList<String> getQueryResult(String query){
        ArrayList<String> arrayList = null;
        Connection connection = null;
        GlobalParameters globalParameters = new GlobalParameters();


        try {
            String driverName = "org.gjt.mm.mysql.Driver";

            Class.forName(driverName);
            java.sql.Statement stmt = null;
            connection = DriverManager.getConnection(globalParameters.DB_URL, globalParameters.DB_USER, globalParameters.DB_PASSWORD);

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if(!rs.isBeforeFirst()){
                return null;
            }

            else{
                int numberOfColumns;
                ResultSetMetaData metadata=null;

                arrayList = new ArrayList<String>();
                metadata = rs.getMetaData();
                numberOfColumns = metadata.getColumnCount();

                while (rs.next()) {
                    int i = 1;
                    while(i <= numberOfColumns) {
                        arrayList.add(rs.getString(i++));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static void executeQuery(String query){
        Connection connection = null;

        try {
            String driverName = "org.gjt.mm.mysql.Driver";

            Class.forName(driverName);
            Statement stmt = null;
            connection = DriverManager.getConnection("utilizar os parãmetros globais para montar a string de conexão de acordo com db utilizado");

            stmt = connection.createStatement();
            stmt.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void cleanDB(){
        Connection connection = null;
        GlobalParameters globalParameters = new GlobalParameters();

        String queriesPath = System.getProperty("user.dir")+"/src/test/java/com/desafioselenium/queries/";
        String query = Utils.readFileToAString(queriesPath + "cleanDatabase.sql");

        try {
            String driverName = "org.gjt.mm.mysql.Driver";

            Class.forName(driverName);
            Statement stmt = null;
            connection = DriverManager.getConnection(globalParameters.DB_URL, globalParameters.DB_USER, globalParameters.DB_PASSWORD);

            stmt = connection.createStatement();
            stmt.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void executeInitialQuery(){

        GlobalParameters globalParameters = new GlobalParameters();

        String queriesPath = System.getProperty("user.dir")+"/src/test/java/com/desafioselenium/queries/";

        try {
            Runtime runtimeProcess = Runtime.getRuntime();
            runtimeProcess.exec("cmd /c start " + queriesPath + "restore.bat");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
