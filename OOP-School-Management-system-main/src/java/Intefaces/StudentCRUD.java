package Intefaces;

import Models.Student;
import java.util.List;

public interface StudentCRUD {
    public List list_array();
    public Student list(int id);
    public boolean add(Student sd);
    public boolean edit(Student sd);
    public boolean delete(int id);
}
