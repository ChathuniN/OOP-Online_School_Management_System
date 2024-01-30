package Intefaces;

import Models.Course;
import java.util.List;

public interface CourseCRUD {
    public List list_array();
    public Course list(int id);
    public boolean add(Course c);
    public boolean edit(Course c);
    public boolean delete(int id);
}
