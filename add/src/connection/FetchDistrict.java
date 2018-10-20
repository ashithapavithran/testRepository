package connection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
public class FetchDistrict {
	private static Connection connection = null;
	public static Connection getConnection() {
	if (connection != null)
	return connection;
else {
try {

Class.forName("org.postgresql.Driver");
  connection = DriverManager.getConnection("jdbc:postgresql://10.11.3.7/ehos_nimhans",
	        "postgres", "postgres");
} catch (ClassNotFoundException e) {
e.printStackTrace();
} catch (SQLException e) {
e.printStackTrace();
} 
return connection;
}
}

public static ArrayList<User> getAllUser(String catcode) {
connection = FetchDistrict.getConnection();
ArrayList<User> userList = new ArrayList<User>();
try {
Statement statement = connection.createStatement();
String sql="select * from mas_district where scode='"+catcode+"' ";

ResultSet rs = statement.executeQuery(sql);
while(rs.next()) { 
User user=new User();
user.setState(rs.getString("district_name"));
user.setMale(rs.getInt("scode"));
userList.add(user);
}
} catch (SQLException e) {
e.printStackTrace();
}
return userList;
}
}