package Models;

public class StudentReport {
    
    int student_id;
    String student_name;
    String course_name; 
    int course_id;
    String attendance;

    public StudentReport() {
    }

    public StudentReport(String student_name, String course_name, int course_id, String attendance) {
        this.student_name = student_name;
        this.course_name = course_name;
        this.course_id = course_id;
        this.attendance = attendance;
    }

    public int getStudentId() {
        return student_id;
    }

    public void setStudentId(int student_id) {
        this.student_id = student_id;
    }

    public String getStudentName() {
        return student_name;
    }

    public void setStudentName(String student_name) {
        this.student_name = student_name;
    }

    public String getCourseName() {
        return course_name;
    }

    public void setCourseName(String course_name) {
        this.course_name = course_name;
    }

    public int getCourseId() {
        return course_id;
    }

    public void setCourseId(int course_id) {
        this.course_id = course_id;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }
    
    
}
