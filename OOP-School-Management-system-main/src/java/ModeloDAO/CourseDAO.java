package ModeloDAO;

import Config.ConDB;
import Models.Course;
import Intefaces.CourseCRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO implements CourseCRUD{
    
    ConDB cn=new ConDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Course course=new Course();

    @Override
    public List list_array() {
        
        // Create Array List with type of Course
        ArrayList<Course>list=new ArrayList<>();
        
        String sql="select * from courses";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Course c=new Course();
                c.setCourseId(rs.getInt("course_id"));
                c.setCourseName(rs.getString("course_name"));
                c.setDescription(rs.getString("description"));
                
                list.add(c);
            }
        }catch(Exception e){
            
        }
        
        return list;
    }

    @Override
    public Course list(int id) {
        String sql="select * from courses where course_id="+id;
        
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){                
                course.setCourseId(rs.getInt("course_id"));
                course.setCourseName(rs.getString("course_name"));
                course.setDescription(rs.getString("description"));
            }
        } catch (Exception e) {
        }
        return course;
    }

    @Override
    public boolean add(Course c) {
        String sql = "insert into courses(course_name,description) values ('"+c.getCourseName()+"','"+c.getDescription()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Course c) {
        String sql="update events set courses='"+c.getCourseName()+"'description='"+c.getDescription()+"'where course_id="+c.getCourseId();
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
        String sql="delete from courses where course_id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
