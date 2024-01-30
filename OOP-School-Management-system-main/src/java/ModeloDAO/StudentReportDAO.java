package ModeloDAO;

import Config.ConDB;
import Models.StudentReport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentReportDAO {
    
    ConDB cn=new ConDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    StudentReport student_report=new StudentReport();

    public List list_array() {
        
        // Create Array List with type of StudentReport
        ArrayList<StudentReport>list=new ArrayList<>();
        
        String sql="SELECT students.student_id, students.student_name, courses.course_name, student_attendance.attendance FROM students, courses, student_attendance WHERE students.course_id = courses.course_id AND student_attendance.student_id = students.student_id;";
        String total = "SELECT COUNT(student_attendance.student_id) AS total FROM student_attendance";
        String attendance = "SELECT student_id, COUNT(student_attendance.student_id) AS attendance FROM student_attendance GROUP BY student_attendance.student_id";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                StudentReport sd=new StudentReport();
                sd.setStudentId(rs.getInt("student_id"));
                sd.setStudentName(rs.getString("student_name"));
                sd.setCourseName(rs.getString("course_name"));
                sd.setAttendance(rs.getString("attendance"));
                               
                list.add(sd);
            }
        }catch(Exception e){
            
        }
        
        return list;
    }
}
