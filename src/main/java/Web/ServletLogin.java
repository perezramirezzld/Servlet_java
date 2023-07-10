
package Web;

import java.io.IOException;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Servletlogin")
public class ServletLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contraseña");
        System.out.println("usuario");
        System.out.println("contraseña");
        if ("Admin".equals(usuario)) {
           
            if("123456".equals(contraseña)){
                 request.getRequestDispatcher("Inicio.jsp").forward(request, response);
            //  response.sendRedirect("Inicio.jsp");
            }
            else{
                 sesion.setAttribute("Error", "");
                 sesion.setAttribute("Error1", "Error contraseña");
                 request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            sesion.setAttribute("Error", "Error Usuario");
            sesion.setAttribute("Error1", "");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            //  response.sendRedirect("index.jsp");
        }

    }
    @Override
       protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
         sesion.setAttribute("Error", "");
         sesion.setAttribute("Error1", "");
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contraseña");
        System.out.println("usuario");
        System.out.println("contraseña");
        request.getRequestDispatcher("login.jsp").forward(request, response);

    }
}
