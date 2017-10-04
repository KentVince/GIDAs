/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gidas;

import static gidas.classDb.JDBC_DRIVER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ITCDD-PROGRAMMING
 */


public class CommonDB {
    
  
   static String us = "root";
   static String pass = "145";
   static String bd = "common_db";
   static String url = "jdbc:mysql://192.168.6.13/"+bd;
    
   public Connection con = null;
 
    //public static String DATABASE_URL = "jdbc:mysql://localhost/oredatabase";
    /*
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://192.168.6.13/common_db";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "145";
   public static Statement s = null; 
   public static Connection conn = null;
    
    */
    
    
    
    public CommonDB(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, us, pass);
            
            if(con!=null){
                System.out.println("kentoi");
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public Connection getConnect(){
        return con;
    }
    
    public void desconnect(){
        con = null;
    }
    
    public static void main(String[] args) {
        CommonDB c = new CommonDB();
        c.getConnect();
    }
   
   
   
   
   /*
    public static void CommonDB() {
        
        try {
            Class.forName(JDBC_DRIVER).newInstance();
            if (conn == null) {
                conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Database connected...");
            } else if (conn.isClosed()) {
                conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            }
        } catch (Exception x) {
            System.err.println("Cannot Connect to Database...");
        }
   }
    
    
    
     public Connection getConnect(){
        return conn;
    }
    
    public void desconnect(){
        conn = null;
    }
    
    public static void main(String[] args) {
        CommonDB c = new CommonDB();
        c.getConnect();
    }
   
   
   
   */
}
