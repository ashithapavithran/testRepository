package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Database {
	 public Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
	Connection connection=null;;
   
 
    Class.forName("org.postgresql.Driver");
    connection = DriverManager.getConnection("jdbc:postgresql://10.11.3.7/ehos_nimhans",
	        "postgres", "postgres");
return connection;
}
}