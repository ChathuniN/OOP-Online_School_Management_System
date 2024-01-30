package Controlador.admin;

import Models.Quiz;
import ModeloDAO.QuizDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "QuizServlet", urlPatterns = {"/QuizServlet"})
public class QuizServlet extends HttpServlet {
    
    // Get url patterns to variables
    String list="staff/quiz/list.jsp";
    String add="staff/quiz/add.jsp";
    String edit="staff/qiz/edit.jsp";    
    
    Quiz ex=new Quiz();
    QuizDAO dao=new QuizDAO();
    int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet QuizServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet QuizServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url="";
        String action=request.getParameter("action");
        
        if(action.equalsIgnoreCase("list")){
            url=list;            
        }else if(action.equalsIgnoreCase("add")){
            url=add;
        }else if(action.equalsIgnoreCase("addrow")){
           
            String question=request.getParameter("txtQue");
            String ans1=request.getParameter("txtAns1");
            String ans2=request.getParameter("txtAns2");
            String ans3=request.getParameter("txtAns3");
            String ans4=request.getParameter("txtAns4");
            int correct_ans_id=Integer.parseInt(request.getParameter("txtAns"));
           
          
                ex.setQuestion(question);
                ex.setAns1(ans1);
                ex.setAns2(ans2);
                ex.setAns3(ans3);
                ex.setAns4(ans4);
                ex.setCorrectAnsId(correct_ans_id);
                dao.add(ex);
            url=list;
        }else if(action.equalsIgnoreCase("edit")){
            request.setAttribute("quizId",request.getParameter("id"));
            url=edit;
        }else if(action.equalsIgnoreCase("editrow")){
           
           id =Integer.parseInt(request.getParameter("txtExamId"));
           String question=request.getParameter("txtExamCode");
           String ans1=request.getParameter("txtExamName");
           String ans2=request.getParameter("txtExamName");
           String ans3=request.getParameter("txtExamName");
           String ans4=request.getParameter("txtExamName");
           int correct_ans_id=Integer.parseInt(request.getParameter("txtHallNo"));
            
            ex.setQuizId(id);
            ex.setQuestion(question);
            ex.setAns1(ans1);
            ex.setAns2(ans2);
            ex.setAns3(ans3);
            ex.setAns4(ans4);
            ex.setCorrectAnsId(correct_ans_id);
            dao.edit(ex);
            url=list;
        }else if(action.equalsIgnoreCase("delete")){
            id=Integer.parseInt(request.getParameter("id"));
            ex.setQuizId(id);
            dao.delete(id);
            url=list;
        }
        
        RequestDispatcher event=request.getRequestDispatcher(url);
        event.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}