package Controlador.admin;

import Models.User;
import ModeloDAO.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

    String list="admin/users/list.jsp";
    String add="admin/users/add.jsp";
    String edit="admin/users/edit.jsp";
    User per=new User();
    UserDAO dao=new UserDAO();
    int id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
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
        }
        else if(action.equalsIgnoreCase("addrow")){
            String email=request.getParameter("txtEmail");
            String password=request.getParameter("txtPassword");
            String role=request.getParameter("cmbRole");
            per.setEmail(email);
            per.setPassword(password);
            per.setRole(role);
            dao.add(per);
            url=list;
        }
        else if(action.equalsIgnoreCase("edit")){
            request.setAttribute("userId",request.getParameter("id"));
            url=edit;
        }
        else if(action.equalsIgnoreCase("editrow")){
            id=Integer.parseInt(request.getParameter("txtUserId"));
            String email=request.getParameter("txtEmail");
            String password=request.getParameter("txtPassword");
            String role=request.getParameter("cmbRole");
            per.setUserId(id);
            per.setEmail(email);
            per.setPassword(password);
            per.setRole(role);
            dao.edit(per);
            url=list;
        }
        else if(action.equalsIgnoreCase("delete")){
            id=Integer.parseInt(request.getParameter("id"));
            per.setUserId(id);
            dao.delete(id);
            url=list;
        }
        RequestDispatcher vista=request.getRequestDispatcher(url);
        vista.forward(request, response);
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
