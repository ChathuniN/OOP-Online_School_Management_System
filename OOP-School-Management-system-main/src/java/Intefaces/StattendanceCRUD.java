package Intefaces;

import Models.Stattendance;
import java.util.List;

public interface StattendanceCRUD {
    public List list_array();
    public Stattendance list(int id);
    public boolean add(Stattendance sa);
    public boolean edit(Stattendance sa);
    public boolean delete(int id);
}
