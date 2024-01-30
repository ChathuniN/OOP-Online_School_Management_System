package Intefaces;

import Models.Quiz;
import java.util.List;

public interface QuizCRUD {
    public List list_array();
    public Quiz list(int id);
    public boolean add(Quiz q);
    public boolean edit(Quiz q);
    public boolean delete(int id);
}
