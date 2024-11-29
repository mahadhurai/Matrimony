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

@WebServlet(name = "LogoutSt", urlPatterns = {"/logout"})
public class LogoutSt extends HttpServlet {

    public ResultSet rs;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        String name, ph;
        name = req.getParameter("Oname");
        ph = req.getParameter("Oph");
        DataBase db = new DataBase("marriage");
        db.tbName = "matrimony";
        try {
            String r = db.select(ph);
            if ((ph.isEmpty()) || (name.isEmpty())){
                RequestDispatcher rdis = req.getRequestDispatcher("/logout.html");
                rdis.include(req, res);
                out.println("<script>alert('Input is empty. Please Enter valid Details')</script>");
            }
            else if (ph.equals(r)) {
                RequestDispatcher rdis = req.getRequestDispatcher("/index.html");
                rdis.include(req, res);
                out.println("<script>alert('Successfully Logout')</script>");
            } else {
                RequestDispatcher rdis = req.getRequestDispatcher("/logout.html");
                rdis.include(req, res);
                out.println("<script>alert('Invalid Details')</script>");
            }
        } catch (Exception ex) {
            out.println("<script>alert('Login Error:'" + ex + "')</script>");
        }
    }
}
