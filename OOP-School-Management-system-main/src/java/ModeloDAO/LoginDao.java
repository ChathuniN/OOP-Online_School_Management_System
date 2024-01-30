package ModeloDAO;

// Import Packages Needed
import java.sql.*;

// Import Login Model
import Models.LoginBean;
import Config.DBConnection;

public class LoginDao {
    public String authenticateUser(LoginBean loginBean)
    {
        String email = loginBean.getEmail();
        String password = loginBean.getPassword();
        String role = loginBean.getRole();

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String emailDB = "";
        String passwordDB = "";
        String roleDB = "";

        try
        {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select email,password,role from users");

            while(resultSet.next())
            {
                emailDB = resultSet.getString("email");
                passwordDB = resultSet.getString("password");
                roleDB = resultSet.getString("role");

                if(email.equals(emailDB) && password.equals(passwordDB) && roleDB.equals("Admin"))
                    return "Admin_Role";
                else if(email.equals(emailDB) && password.equals(passwordDB) && roleDB.equals("Technician"))
                    return "Technician_Role";
                else if(email.equals(emailDB) && password.equals(passwordDB) && roleDB.equals("Staff"))
                    return "Staff_Role";
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }
}
