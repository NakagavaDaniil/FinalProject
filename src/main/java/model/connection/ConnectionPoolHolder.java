package model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPoolHolder {

        private static Connection connection;
        public static Connection getConnection() throws SQLException {
            if(connection==null){

                try {


                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb?characterEncoding=utf-8",
                            "root",
                            "password");

                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            return connection;
        }
}
