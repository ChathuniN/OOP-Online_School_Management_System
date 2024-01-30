package Controlador.admin;

import Models.Exam;
import ModeloDAO.ExamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExamServlet", urlPatterns = {"/ExamServlet"})
public class ExamServlet extends HttpServlet {
    
    // Get url patterns to variables
    String list="staff/exams/list.jsp";
    String add="staff/exams/add.jsp";
    String edit="staff/exams/edit.jsp";    
    
    Exam ex=new Exam();
    ExamDAO dao=new ExamDAO();
    int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ExamServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ExamServlet at " + request.getContextPath() + "</h1>");
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
            String exam_code=request.getParameter("txtExamCode");
            String exam_name=request.getParameter("txtExamName");
            int course_id=Integer.parseInt(request.getParameter("cmbCourse"));
            Date exam_date=Date.valueOf(request.getParameter("dateExamDate"));
            int hall_no=Integer.parseInt(request.getParameter("txtHallNo"));
            ex.setExamCode(exam_code);
            ex.setExamName(exam_name);
            ex.setCourseId(course_id);
            ex.setExamDate(exam_date);
            ex.setHallNo(hall_no);
            dao.add(ex);
            url=list;
        }else if(action.equalsIgnoreCase("edit")){
            request.setAttribute("examId",request.getParameter("id"));
            url=edit;
        }else if(action.equalsIgnoreCase("editrow")){
            id=Integer.parseInt(request.getParameter("txtExamId"));
            String exam_code=request.getParameter("txtExamCode");
            String exam_name=request.getParameter("txtExamName");
            int course_id=Integer.parseInt(request.getParameter("cmbCourse"));
            Date exam_date=Date.valueOf(request.getParameter("dateExamDate"));
            int hall_no=Integer.parseInt(request.getParameter("txtHallNo"));
            ex.setExamId(id);
            ex.setExamCode(exam_code);
            ex.setExamName(exam_name);
            ex.setCourseId(course_id);
            ex.setExamDate(exam_date);
            ex.setHallNo(hall_no);
            dao.edit(ex);
            url=list;
        }else if(action.equalsIgnoreCase("delete")){
            id=Integer.parseInt(request.getParameter("id"));
            ex.setExamId(id);
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