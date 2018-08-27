package model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionPoolHolder {

        private static Connection connection;
        public static Connection getConnection() throws SQLException {
            if(connection==null){

                try {

                        Class.forName("com.mysql.jdbc.Driver");

                    ResourceBundle sqlData = ResourceBundle.getBundle("MySqlConnection");

                    connection = DriverManager.getConnection(sqlData.getString("url_characterEncoding"),
                            sqlData.getString("user"),
                            sqlData.getString("password"));

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            return connection;
        }
}
