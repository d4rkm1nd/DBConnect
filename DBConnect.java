import java.sql.*;
import java.sql.Statement;

import static java.lang.System.err;

public class DBConnect {
    public static void main(String[] args){

        try {
            String host = "jdbc:mysql://localhost:3306/students";
            String User = "root";
            String Pass = "*********";
            Connection con = DriverManager.getConnection(host, User, Pass);

            Statement stat = con.createStatement();
            String sql = "select * from group_a";
            ResultSet rs = stat.executeQuery(sql);

            //Statement statement = con.createStatement();
            //statement.executeUpdate("INSERT INTO group_a " + "VALUES (5, 'Andreea', 'Bianca', 8)");

            while ( rs.next()) {
                int id_col = rs.getInt("ID");
                String first_name = rs.getString("First_Name");
                String last_name = rs.getString("Last_Name");
                String avg = rs.getString("Average");

                String p = id_col + " " + first_name + " " + last_name + " " + avg;
                System.out.println(p);
            }
        }
        catch(SQLException err){
            System.out.print(err.getMessage());
        }
    }
}
