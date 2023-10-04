import Frames.LogInFrame;
import Frames.SignUpFrame;
import java.awt.*;
import java.sql.*;

public class LogicManager extends Component {

    public LogicManager() {
        //variable to check if registration is available
        boolean hasRegistredUsers = connectToDatabase();
        LogInFrame logInFrame = null;
        if (hasRegistredUsers) {

            logInFrame = new LogInFrame();

        } else {
            new SignUpFrame();

        }
        assert logInFrame != null;
        logInFrame.getSignUp().addActionListener(e -> new SignUpFrame());
    }

    private boolean connectToDatabase() {
        boolean hasRegistredUsers = false;

        final String MYSQL_SERVER_URL = "jdbc:mysql://localhost/";
        final String DB_URL = "jdbc:mysql://localhost/MyStore?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            //Connect to MYSQL server and create the database if not created
            Connection conn = DriverManager.getConnection(MYSQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS MyStore");
            statement.close();
            conn.close();

            // Connect to the database and create the table "users" if cot created
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT( 10 ) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "email VARCHAR(200) NOT NULL UNIQUE,"
                    + "fname VARCHAR(200) NOT NULL,"
                    + "lname VARCHAR(200) NOT NULL,"
                    + "username VARCHAR(200) NOT NULL,"
                    + "phone VARCHAR(200),"
                    + "password VARCHAR(200) NOT NULL"
                    + ")";
            statement.executeUpdate(sql);

            //check if we have users in the table users
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM users");

            if (resultSet.next()) {
                int numUsers = resultSet.getInt(1);
                if (numUsers > 0) {
                    hasRegistredUsers = true;
                }
            }

            statement.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return hasRegistredUsers;
    }

}
