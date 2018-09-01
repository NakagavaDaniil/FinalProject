package model.connection;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class ConnectionPoolHolder {

    //    private static Connection connection;
//        public static Connection getConnection() throws SQLException {
//            if(connection==null){
//
//                try {
//
//                        Class.forName("com.mysql.jdbc.Driver");
//
//                    ResourceBundle sqlData = ResourceBundle.getBundle("MySqlConnection");
//
//                    connection = DriverManager.getConnection(sqlData.getString("url_characterEncoding"),
//                            sqlData.getString("user"),
//                            sqlData.getString("password"));
//
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//            return connection;
//        }
private static volatile DataSource dataSource;
    public static DataSource getDataSource(){

        if (dataSource == null){
            synchronized (ConnectionPoolHolder.class) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if (dataSource == null) {
                    BasicDataSource ds = new BasicDataSource();
                    ds.setUrl("jdbc:mysql://localhost:3306/projectdb?characterEncoding=utf-8");
                    ds.setUsername("root");
                    ds.setPassword("password");
                    ds.setMinIdle(5);
                    ds.setMaxIdle(10);
                    ds.setMaxOpenPreparedStatements(100);
                    dataSource = ds;
                }
            }
        }
        return dataSource;

    }

}
