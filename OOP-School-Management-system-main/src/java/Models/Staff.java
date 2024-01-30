package Models;
public class Staff {
    
    // Define VAriables  
    int member_id;
    String member_code;
    String member_name;

    public Staff() {
    }

    public Staff(String member_code, String member_name) {
        this.member_code = member_code;
        this.member_name = member_name;
    }

    public int getMemberId() {
        return member_id;
    }

    public void setMemberId(int member_id) {
        this.member_id = member_id;
    }

    public String getMemberCode() {
        return member_code;
    }

    public void setMemberCode(String member_code) {
        this.member_code = member_code;
    }

    public String getMemberName() {
        return member_name;
    }

    public void setMemberName(String member_name) {
        this.member_name = member_name;
    }
      
    
    
}
