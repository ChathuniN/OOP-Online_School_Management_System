package ModeloDAO;

import Config.ConDB;
import Intefaces.ExamCRUD;
import Models.Exam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExamDAO implements ExamCRUD{
    
    ConDB cn=new ConDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Exam exam=new Exam();

    @Override
    public List list_array() {
        
        // Create Array List with type of Exam
        ArrayList<Exam>list=new ArrayList<>();
        
        String sql="select * from exams";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Exam ex=new Exam();
                ex.setExamId(rs.getInt("exam_id"));
                ex.setExamCode(rs.getString("exam_code"));
                ex.setExamName(rs.getString("exam_name"));
                ex.setCourseId(rs.getInt("course_id"));
                ex.setExamDate(rs.getDate("exam_date"));
                ex.setHallNo(rs.getInt("hall_no"));
                
                list.add(ex);
            }
        }catch(Exception e){
            
        }
        
        return list;
    }

    @Override
    public Exam list(int id) {
        String sql="select * from exams where exam_id="+id;
        
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){                
                exam.setExamId(rs.getInt("exam_id"));
                exam.setExamCode(rs.getString("exam_code"));
                exam.setExamName(rs.getString("exam_name"));
                exam.setCourseId(rs.getInt("course_id"));
                exam.setExamDate(rs.getDate("exam_date"));
                exam.setHallNo(rs.getInt("hall_no"));
            }
        } catch (Exception e) {
        }
        return exam;
    }

    @Override
    public boolean add(Exam ex) {
        String sql = "INSERT INTO exams(exam_code, exam_name, course_id, exam_date, hall_no) VALUES ('"+ex.getExamCode()+"','"+ex.getExamName()+"','"+ex.getCourseId()+"','"+ex.getExamDate()+"','"+ex.getHallNo()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Exam ex) {
        String sql="update exams set exam_code='"+ex.getExamCode()+"',exam_name='"+ex.getExamName()+"',course_id='"+ex.getCourseId()+"',exam_date='"+ex.getExamDate()+"',hall_no='"+ex.getHallNo()+"'where exam_id="+ex.getExamId();
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
        String sql="delete from exams where exam_id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
