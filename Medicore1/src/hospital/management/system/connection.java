package hospital.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connection {

    Connection connect;
    Statement statement;

    public connection(){
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsDB", "root","Nehal@1301");
            statement = connect.createStatement();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
