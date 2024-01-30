package Controlador;

import Models.LoginBean;
import ModeloDAO.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
//@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public LoginServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        LoginBean loginBean = new LoginBean();

        loginBean.setEmail(email);
        loginBean.setPassword(password);

        LoginDao loginDao = new LoginDao();

        try
        {
            String userValidate = loginDao.authenticateUser(loginBean);

            if(userValidate.equals("Admin_Role"))
            {
                System.out.println("Admin's Home");

                HttpSession session = request.getSession(); //Creating a session
                session.setAttribute("Admin", email); //setting session attribute
                request.setAttribute("email", email);

                request.getRequestDispatcher("admin/student/list.jsp").forward(request, response);
            }
            else if(userValidate.equals("Technician_Role"))
            {
                System.out.println("Technician's Home");

                HttpSession session = request.getSession();
                session.setAttribute("Technician", email);
                request.setAttribute("email", email);

                request.getRequestDispatcher("tech/student/list.jsp").forward(request, response);
            }
            else if(userValidate.equals("Staff_Role"))
            {
                System.out.println("Staff's Home");

                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(10*60);
                session.setAttribute("Staff", email);
                request.setAttribute("email", email);

                request.getRequestDispatcher("staff/exams/list.jsp").forward(request, response);
            }
            else
            {
                System.out.println("Error message = "+userValidate);
                request.setAttribute("errMessage", userValidate);request.getRequestDispatcher("index.jsp").forward(request, response);

                
            }
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
    } //End of doPost()
}