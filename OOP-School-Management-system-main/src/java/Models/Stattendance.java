package Models;

import java.sql.Date;

public class Stattendance {
    
    // Define VAriables  
    int student_id;
    Date date;
    String attendance;

    public Stattendance() {
    }

    public Stattendance(Date date, String attendance) {
        this.date = date;
        this.attendance = attendance;
    }

    public int getStudentId() {
        return student_id;
    }

    public void setStudentId(int student_id) {
        this.student_id = student_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    
    
}
