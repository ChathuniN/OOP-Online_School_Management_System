package Intefaces;

import Models.Staff;
import java.util.List;

public interface StaffCRUD {
    public List list_array();
    public Staff list(int id);
    public boolean add(Staff st);
    public boolean edit(Staff st);
    public boolean delete(int id);
}
