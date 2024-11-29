package pkg1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginSt", urlPatterns = {"/login"})
public class LoginSt extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        String name, ph;
        name = req.getParameter("Lname");
        ph = req.getParameter("Lph");
        DataBase db = new DataBase("marriage");
        db.tbName = "matrimony";
        try {
            String r = db.select(ph);
            if ((ph.isEmpty()) || (name.isEmpty())){
                RequestDispatcher rdis = req.getRequestDispatcher("/login.html");
                rdis.include(req, res);
                out.println("<script>alert('Input is empty. Please Enter valid Details')</script>");
            }
            else if (ph.equals(r)) {
                RequestDispatcher rdis = req.getRequestDispatcher("/profile");
                rdis.include(req, res);
                out.println("<script>alert('Login Successfully')</script>");
            } else {
                RequestDispatcher rdis = req.getRequestDispatcher("/login.html");
                rdis.include(req, res);
                out.println("<script>alert('Invalid Details')</script>");
            }
        } catch (Exception ex) {
            out.println("<script>alert('Login Error:'" + ex + "')</script>");
        }

    }
}
