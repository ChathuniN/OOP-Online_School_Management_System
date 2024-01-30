package Models;
public class Student {
    
    // Define VAriables  
    int student_id;
    String student_name;
    String course_name;

    public Student() {
    }

    public Student(String student_name, String course_name) {
        this.student_name = student_name;
        this.course_name = course_name;
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
    
    
    
}
