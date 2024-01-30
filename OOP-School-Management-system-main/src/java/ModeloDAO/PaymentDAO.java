package ModeloDAO;

import Config.ConDB;
import Intefaces.PaymentCRUD;
import Models.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO implements PaymentCRUD{
    
    ConDB cn=new ConDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Payment staff=new Payment();

    @Override
    public List list_array() {
        
        // Create Array List with type of Staff
        ArrayList<Payment>list=new ArrayList<>();
        
        String sql="select * from payments";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Payment st=new Payment();
                st.setStudentName(rs.getString("student_name"));
                st.setCourseName(rs.getString("course_name"));
                st.setAmount(rs.getInt("amount"));
                
                
                list.add(st);
            }
        }catch(Exception e){
            
        }
        
        return list;
    }

    @Override
    public Payment list(int id) {
        String sql="select * from payments where member_id="+id;
        
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){                
                staff.setStudentName(rs.getString("student_name"));
                staff.setCourseName(rs.getString("course_name"));
                staff.setAmount(rs.getInt("amount"));
               
            }
        } catch (Exception e) {
        }
        return staff;
    }

    @Override
    public boolean add(Payment st) {
        String sql = "INSERT INTO payments(student_name, course_name,amount) VALUES ('"+st.getStudentName()+"','"+st.getCourseName()+"','"+st.getAmount()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Payment st) {
        String sql="update payments set student_name='"+st.getStudentName()+"',course_name='"+st.getCourseName()+"',amount='"+st.getAmount()+"'where payment_id="+st.getPaymentId();
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
