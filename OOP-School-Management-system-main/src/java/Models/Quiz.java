package Models;



public class Quiz {
    
    // Define VAriables
    int quiz_id;
    String question;
    String ans1;
    String ans2;
    String ans3;
    String ans4;
    int correct_ans_id;   

       // Call default constructor

    public Quiz() {
    }

    public Quiz(String question, String ans1, String ans2, String ans3, String ans4, int correct_ans_id) {
        this.question = question;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
        this.correct_ans_id = correct_ans_id;
    }

    public int getQuizId() {
        return quiz_id;
    }

    public void setQuizId(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    public String getAns4() {
        return ans4;
    }

    public void setAns4(String ans4) {
        this.ans4 = ans4;
    }

    public int getCorrectAnsId() {
        return correct_ans_id;
    }

    public void setCorrectAnsId(int correct_ans_id) {
        this.correct_ans_id = correct_ans_id;
    }


}
