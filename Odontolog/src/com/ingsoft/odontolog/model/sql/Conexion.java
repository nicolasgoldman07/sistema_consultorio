package com.ingsoft.odontolog.model.sql;
import java.sql.*;


/**
 * Clase que permite conectar con la base de datos
**/

public class Conexion {
   static String bd = "login_db";
   static String login = "root";
   static String password = "demoniofc";
   static String url = "jdbc:mysql://localhost/login_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

   private Connection conn = null;

   /** Constructor de DbConnection */
   public Conexion() {
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

