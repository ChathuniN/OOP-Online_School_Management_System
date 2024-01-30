package ModeloDAO;

import Config.ConDB;
import Intefaces.StaffCRUD;
import Models.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO implements StaffCRUD{
    
    ConDB cn=new ConDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Staff staff=new Staff();

    @Override
    public List list_array() {
        
        // Create Array List with type of Staff
        ArrayList<Staff>list=new ArrayList<>();
        
        String sql="select * from staff";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Staff st=new Staff();
                st.setMemberId(rs.getInt("member_id"));
                st.setMemberCode(rs.getString("member_code"));
                st.setMemberName(rs.getString("member_name"));
                
                
                list.add(st);
            }
        }catch(Exception e){
            
        }
        
        return list;
    }

    @Override
    public Staff list(int id) {
        String sql="select * from staff where member_id="+id;
        
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){                
                staff.setMemberId(rs.getInt("member_id"));
                staff.setMemberCode(rs.getString("member_code"));
                staff.setMemberName(rs.getString("member_name"));
               
            }
        } catch (Exception e) {
        }
        return staff;
    }

    @Override
    public boolean add(Staff st) {
        String sql = "INSERT INTO staff(member_code, member_name) VALUES ('"+st.getMemberCode()+"','"+st.getMemberName()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Staff st) {
        String sql="update staff set member_code='"+st.getMemberCode()+"',member_name='"+st.getMemberName()+"'where member_id="+st.getMemberId();
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
        String sql="delete from staff where member_id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
