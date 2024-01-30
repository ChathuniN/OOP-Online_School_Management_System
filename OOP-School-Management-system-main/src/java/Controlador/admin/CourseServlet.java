package Controlador.admin;

import Models.Course;
import ModeloDAO.CourseDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CourseServlet", urlPatterns = {"/CourseServlet"})
public class CourseServlet extends HttpServlet {
    
    // Get url patterns to variables
    String list="admin/courses/list.jsp";
    String add="admin/courses/add.jsp";
    String edit="admin/courses/edit.jsp";    
    
    Course c=new Course();
    CourseDAO dao=new CourseDAO();
    int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CourseServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CourseServlet at " + request.getContextPath() + "</h1>");
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
            String course_name=request.getParameter("txtCourseName");
            String description=request.getParameter("txtDescription");
            c.setCourseName(course_name);
            c.setDescription(description);
            dao.add(c);
            url=list;
        }else if(action.equalsIgnoreCase("edit")){
            request.setAttribute("courseId",request.getParameter("id"));
            url=edit;
        }else if(action.equalsIgnoreCase("editrow")){
            id=Integer.parseInt(request.getParameter("txtCourseId"));
            String course_name=request.getParameter("txtCourseName");
            String description=request.getParameter("txtDescription");
            c.setCourseId(id);
            c.setCourseName(course_name);
            c.setDescription(description);
            dao.edit(c);
            url=list;
        }else if(action.equalsIgnoreCase("delete")){
            id=Integer.parseInt(request.getParameter("id"));
            c.setCourseId(id);
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