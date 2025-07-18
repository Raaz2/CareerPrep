package com.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {
    public static Connection getConnectionToDb() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ResourceBundle rb = ResourceBundle.getBundle("dbdetails");
        return DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("password"));
    }

    public static void closeConnection(Connection conn) throws SQLException {
        if(conn != null) {
            conn.close();
        }
    }

    public static boolean isResultSetEmpty(ResultSet rs) throws SQLException {
        return (!rs.isBeforeFirst() && rs.getRow() == 0) ? true : false;
    }
}
