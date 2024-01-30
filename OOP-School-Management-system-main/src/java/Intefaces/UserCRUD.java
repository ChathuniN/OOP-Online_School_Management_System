
package Intefaces;

import Models.User;
import java.util.List;


public interface UserCRUD {
    public List list_array();
    public User list(int id);
    public boolean add(User per);
    public boolean edit(User per);
    public boolean delete(int id);
}
