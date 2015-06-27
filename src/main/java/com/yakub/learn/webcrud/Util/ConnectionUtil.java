package com.yakub.learn.webcrud.Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

  private static Connection connection;
  private static final String driver = "com.mysql.jdbc.Driver";
  private static final String url = "jdbc:mysql://localhost:3306/pegawai";
  private static final String userName = "root";
  private static final String password = "kyu";


  public static Connection getConnection() {
    try {
      Class.forName(driver);
      connection = DriverManager.getConnection(url, userName, password);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return connection;
  }

}
