package Models;

import java.sql.Date;

public class Course {
    
    // Define VAriables
    int course_id;
    String course_name;
    String description;

    // Call default constructor
    public Course() {
    }

    public Course(String course_name, String description) {
        this.course_name = course_name;
        this.description = description;
    }

    // Create Getters and Setters to access private variables

    public int getCourseId() {
        return course_id;
    }

    public void setCourseId(int course_id) {
        this.course_id = course_id;
    }

    public String getCourseName() {
        return course_name;
    }

    public void setCourseName(String course_name) {
        this.course_name = course_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

}
