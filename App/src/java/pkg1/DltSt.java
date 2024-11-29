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

@WebServlet(name = "DltSt", urlPatterns = {"/delete"})
public class DltSt extends HttpServlet {

    public ResultSet rs;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        String name, ph;
        name = req.getParameter("dname");
        ph = req.getParameter("dph");
        DataBase db = new DataBase("marriage");
        db.tbName = "matrimony";
                    String r=db.select(ph);
        try {
            if ((ph.isEmpty()) || (name.isEmpty())){
                RequestDispatcher rdis = req.getRequestDispatcher("/delete.html");
                rdis.include(req, res);
                out.println("<script>alert('Input is empty. Please Enter valid Details')</script>");
            }
            else if (ph.equals(r)) {
                db.delete(ph);
                RequestDispatcher rdis = req.getRequestDispatcher("/delete.html");
                rdis.include(req, res);
                out.println("<script>alert('Delete Successfully')</script>");
            }
            else{
                RequestDispatcher rdis = req.getRequestDispatcher("/index.html");
                rdis.include(req, res);
                out.println("<script>alert('invalid details')</script>");
            }

        } catch (Exception ex) {
            out.println("<script>alert('Delete Error:'" + ex + "')</script>");

        }
    }

}
