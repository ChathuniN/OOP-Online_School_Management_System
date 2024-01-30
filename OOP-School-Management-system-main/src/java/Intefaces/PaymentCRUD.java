package Intefaces;

import Models.Payment;
import java.util.List;

public interface PaymentCRUD {
    public List list_array();
    public Payment list(int id);
    public boolean add(Payment st);
    public boolean edit(Payment st);
    public boolean delete(int id);
}
