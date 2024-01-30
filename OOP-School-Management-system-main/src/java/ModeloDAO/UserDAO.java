package ModeloDAO;

import Config.ConDB;
import Models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Intefaces.UserCRUD;

public class UserDAO implements UserCRUD{
    ConDB cn=new ConDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    User user=new User();
    
    @Override
    public List list_array() {
        ArrayList<User>list=new ArrayList<>();
        String sql="select * from users";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                User per=new User();
                per.setUserId(rs.getInt("user_id"));
                per.setEmail(rs.getString("email"));
                per.setPassword(rs.getString("password"));
                per.setRole(rs.getString("role"));
                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public User list(int id) {
        String sql="select * from users where user_id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                user.setUserId(rs.getInt("user_id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                
            }
        } catch (Exception e) {
        }
        return user;
    }

    @Override
    public boolean add(User per) {
       String sql="insert into users(email, password, role)values('"+per.getEmail()+"','"+per.getPassword()+"','"+per.getRole()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(User per) {
        String sql="update users set email='"+per.getEmail()+"',password='"+per.getPassword()+"',role='"+per.getRole()+"'where user_id="+per.getUserId();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql="delete from users where user_id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
