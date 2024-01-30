package ModeloDAO;

import Config.ConDB;
import Intefaces.StudentCRUD;
import Models.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements StudentCRUD{
    
    ConDB cn=new ConDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Student student=new Student();

    @Override
    public List list_array() {
        
        // Create Array List with type of Student
        ArrayList<Student>list=new ArrayList<>();
        
        String sql="select * from students";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Student sd=new Student();
                sd.setStudentId(rs.getInt("student_id"));
                sd.setStudentName(rs.getString("student_name"));
                sd.setCourseName(rs.getString("course_name"));
                
                
                list.add(sd);
            }
        }catch(Exception e){
            
        }
        
        return list;
    }

    @Override
    public Student list(int id) {
        String sql="select * from students where student_id="+id;
        
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){                
                student.setStudentId(rs.getInt("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setCourseName(rs.getString("course_name"));
               
            }
        } catch (Exception e) {
            
        }
        return student;
    }

    @Override
    public boolean add(Student sd) {
        String sql = "INSERT INTO students(student_name, course_name) VALUES ('"+sd.getStudentName()+"','"+sd.getCourseName()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Student sd) {
        String sql="update students set student_name='"+sd.getStudentName()+"',course_name='"+sd.getCourseName()+"'where student_id="+sd.getStudentId();
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
        String sql="delete from students where student_id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
}
