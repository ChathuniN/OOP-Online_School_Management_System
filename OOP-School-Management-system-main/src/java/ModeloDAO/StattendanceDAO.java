package ModeloDAO;

import Config.ConDB;
import Intefaces.StattendanceCRUD;
import Models.Stattendance;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StattendanceDAO implements StattendanceCRUD{
    
    ConDB cn=new ConDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Stattendance stattendance=new Stattendance();

    @Override
    public List list_array() {
        
        // Create Array List with type of Stattendance
        ArrayList<Stattendance>list=new ArrayList<>();
        
        String sql="select * from student_attendance";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Stattendance sa=new Stattendance();
                sa.setStudentId(rs.getInt("student_id"));
                sa.setDate(Date.valueOf(rs.getString("date")));
                sa.setAttendance(rs.getString("attendance"));
                
                
                list.add(sa);
            }
        }catch(Exception e){
            
        }
        
        return list;
    }

    @Override
    public Stattendance list(int id) {
        String sql="select * from student_attendance where student_id="+id;
        
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){                
                stattendance.setStudentId(rs.getInt("student_id"));
                stattendance.setDate(Date.valueOf(rs.getString("date")));
                stattendance.setAttendance(rs.getString("attendance"));
               
            }
        } catch (Exception e) {
        }
        return stattendance;
    }

    @Override
    public boolean add(Stattendance sa) {
        String sql = "INSERT INTO student_attendance(date, attendance) VALUES ('"+sa.getDate()+"','"+sa.getAttendance()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Stattendance sa) {
        String sql="update student_attendance set date='"+sa.getDate()+"',attendance='"+sa.getAttendance()+"'where student_id="+sa.getStudentId();
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
        String sql="delete from student_attendance where student_id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
