package ModeloDAO;

import Config.ConDB;
import Intefaces.QuizCRUD;
import Models.Quiz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuizDAO implements QuizCRUD{
    
    ConDB cn=new ConDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Quiz exam=new Quiz();

    @Override
    public List list_array() {
        
        // Create Array List with type of Quiz
        ArrayList<Quiz>list=new ArrayList<>();
        
        String sql="select * from quizes";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Quiz ex=new Quiz();
                ex.setQuizId(rs.getInt("quiz_id"));
                ex.setQuestion(rs.getString("question"));
                ex.setAns1(rs.getString("ans1"));
                ex.setAns2(rs.getString("ans2"));
                ex.setAns3(rs.getString("ans3"));
                ex.setAns4(rs.getString("ans4"));
                ex.setCorrectAnsId(rs.getInt("correct_ans_id"));
                list.add(ex);
            }
        }catch(Exception e){
            
        }
        
        return list;
    }

    @Override
    public Quiz list(int id) {
        String sql="select * from quizes where quiz_id="+id;
        
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){                
                                
                exam.setQuizId(rs.getInt("quiz_id"));
                exam.setQuestion(rs.getString("question"));
                exam.setAns1(rs.getString("ans1"));
                exam.setAns2(rs.getString("ans2"));
                exam.setAns3(rs.getString("ans3"));
                exam.setAns4(rs.getString("ans4"));
                exam.setCorrectAnsId(rs.getInt("correct_ans_id"));
                
            }
            
        } catch (Exception e) {
        }
        return exam;
    }

    @Override
    public boolean add(Quiz ex) {
        String sql = "INSERT INTO quizes(question, ans1, ans2, ans3, ans3, correct_ans_id) VALUES ('"+ex.getQuestion()+"','"+ex.getAns1()+"','"+ex.getAns2()+"','"+ex.getAns3()+"','"+ex.getAns4()+"','"+ex.getCorrectAnsId()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Quiz ex) {
        String sql="update quizes set question='"+ex.getQuestion()+"',ans1='"+ex.getAns1()+"',ans2='"+ex.getAns2()+"',ans3='"+ex.getAns3()+"',ans4='"+ex.getAns4()+"',correct_ans_id='"+ex.getCorrectAnsId()+"'where quiz_id="+ex.getQuizId();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql="delete from quizes where quiz_id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
