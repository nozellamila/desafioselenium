package com.desafioselenium.utils;

import com.desafioselenium.GlobalParameters;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;

import java.util.ArrayList;

import static org.checkerframework.checker.units.UnitsTools.s;

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

    public static void executeInitialQuery() throws IOException, InterruptedException {

        GlobalParameters globalParameters = new GlobalParameters();
        String dbName = "bugtracker";
        String dbUser = globalParameters.DB_USER;
        String dbPass = globalParameters.DB_PASSWORD;

        String restorePath = System.getProperty("user.dir")+"/src/test/java/com/desafioselenium/queries/resetDatabase.sql";

        String[] executeCmd = new String[]{"C:\\wamp64\\bin\\mysql\\mysql5.7.36\\bin\\mysql", dbName, "-u" + dbUser, "-p" + dbPass, "-e", " source " + restorePath};

        try {
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
