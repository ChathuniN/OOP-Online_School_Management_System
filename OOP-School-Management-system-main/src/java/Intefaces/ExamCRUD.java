package Intefaces;

import Models.Exam;
import java.util.List;

public interface ExamCRUD {
    public List list_array();
    public Exam list(int id);
    public boolean add(Exam ex);
    public boolean edit(Exam ex);
    public boolean delete(int id);
}
