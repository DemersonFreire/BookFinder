package bookfinder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
    
    public static Connection getConnection(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://ec2-34-231-63-30.compute-1.amazonaws.com:5432/dmrcj6hfsvkok",
                    "vkfrfwugofjanr","4d7855e1c659624a35a264020e7c65f9f17ab91dbfe0b20055598ee8506ad1d9");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
