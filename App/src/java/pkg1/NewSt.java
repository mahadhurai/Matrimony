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

@WebServlet(name = "NewSt", urlPatterns = {"/new"})
public class NewSt extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        String name, email, ph;
        name = req.getParameter("uname");
        email = req.getParameter("umail");
        ph = req.getParameter("uph");
        DataBase db = new DataBase("marriage");
        db.tbName = "matrimony";
        String r = db.select(ph);
        try {
            if ((ph.isEmpty()) || (name.isEmpty()) || (email.isEmpty())) {
                RequestDispatcher rdis = req.getRequestDispatcher("./new.html");
                rdis.include(req, res);
                out.println("<script>alert('Input is empty. Please Enter valid Details')</script>");
            } else if (ph.equals(r)) {
                RequestDispatcher rdis = req.getRequestDispatcher("./new.html");
                rdis.include(req, res);
                out.println("<script>alert('Already Registered. Please change your mobile Number.')</script>");
            } else {
                db.insert(name, email, ph);
                RequestDispatcher rdis = req.getRequestDispatcher("./index.html");
                rdis.include(req, res);
                out.println("<script>alert('Successfully Registered.Go back to login and see your Profile')</script>");
            }
        } catch (Exception ex) {
            out.println("<script>alert('Sign Error:'" + ex + "')</script>");
        }
    }
}
