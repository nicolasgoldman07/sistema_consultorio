package com.ingsoft.odontolog.model.sql;
import java.sql.*;


/**
 * Clase que permite conectar con la base de datos
**/

public class ConexionLogin {
   static String bd = "odontologin";
   static String login = "odontologin";
   static String password = "Sc7lcPgR-9-2";
   static String url = "jdbc:mysql://den1.mysql6.gear.host/odontologin";

   private Connection conn = null;

   /** Constructor de DbConnection */
   public ConexionLogin() {
      try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection(url,login,password);

         if (conn!=null){
           System.out.println("Conección a base de datos "+bd+" OK");
         }
      } catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }catch(Exception e){
         System.out.println(e);
      }
   }

   
   public Connection getConnection(){
      return conn;
   }

   public void desconectar(){
      conn = null;
   }
}

