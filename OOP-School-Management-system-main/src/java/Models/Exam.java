package Models;

import java.sql.Date;

public class Exam {
    
    // Define VAriables
    int exam_id;
    String exam_code;
    int course_id;
    String exam_name;
    Date exam_date;
    int hall_no;

    // Call default constructor
    public Exam() {
    }

    public Exam(String exam_code, String exam_name, int course_id, Date exam_date, int hall_no) {
        this.exam_code = exam_code;
        this.exam_name = exam_name;
        this.course_id = course_id;        
        this.exam_date = exam_date;
        this.hall_no = hall_no;
    }

    // Create Getters and Setters to access private variables

    public int getExamId() {
        return exam_id;
    }

    public void setExamId(int exam_id) {
        this.exam_id = exam_id;
    }

    public String getExamCode() {
        return exam_code;
    }

    public void setExamCode(String exam_code) {
        this.exam_code = exam_code;
    }

    public String getExamName() {
        return exam_name;
    }

    public void setExamName(String exam_name) {
        this.exam_name = exam_name;
    }

    public int getCourseId() {
        return course_id;
    }

    public void setCourseId(int course_id) {
        this.course_id = course_id;
    }

    public Date getExamDate() {
        return exam_date;
    }

    public void setExamDate(Date exam_date) {
        this.exam_date = exam_date;
    }

    public int getHallNo() {
        return hall_no;
    }

    public void setHallNo(int hall_no) {
        this.hall_no = hall_no;
    }
    
}
