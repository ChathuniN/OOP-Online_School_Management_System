package Controlador;

import Controlador.tech.*;
import Models.Student;
import ModeloDAO.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegsterServlet", urlPatterns = {"/RegsterServlet"})
public class RegisterServlet extends HttpServlet {
    
    // Get url patterns to variables
    String list="index.jsp";
    String add="register.jsp";
    String edit="tech/student/edit.jsp";    
    
    Student sd=new Student();
    StudentDAO dao=new StudentDAO();
    int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentServlet at " + request.getContextPath() + "</h1>");
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
            String student_name=request.getParameter("txtStudentName");
            String course_name=request.getParameter("txtCourseName");
            
            sd.setStudentName(student_name);
            sd.setCourseName(course_name);
           
            dao.add(sd);
            url=list;
        }else if(action.equalsIgnoreCase("edit")){
            request.setAttribute("studentId",request.getParameter("id"));
            url=edit;
        }else if(action.equalsIgnoreCase("editrow")){
            id=Integer.parseInt(request.getParameter("txtStudentId"));
            String student_name=request.getParameter("txtStudentName");
            String course_name=request.getParameter("txtCourseName");
            
            sd.setStudentId(id);
            sd.setStudentName(student_name);
            sd.setCourseName(course_name);
            dao.edit(sd);
            url=list;
        }else if(action.equalsIgnoreCase("delete")){
            id=Integer.parseInt(request.getParameter("id"));
            sd.setStudentId(id);
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