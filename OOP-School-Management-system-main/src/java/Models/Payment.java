package Models;
public class Payment {
    
    // Define VAriables  
    int payment_id;
    String student_name;
    String course_name;
    int amount;

    public Payment() {
    }

    public Payment(String student_name, String course_name) {
        this.student_name = student_name;
        this.course_name = course_name;
    }

    public int getPaymentId() {
        return payment_id;
    }

    public void setPaymentId(int payment_id) {
        this.payment_id = payment_id;
    }

    public String getStudentName() {
        return student_name;
    }

    public void setStudentName(String student_name) {
        this.student_name = student_name;
    }

    public String getCourseName() {
        return course_name;
    }

    public void setCourseName(String course_name) {
        this.course_name = course_name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    
    
    
}
