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

@WebServlet(name = "UpdateSt", urlPatterns = {"/update"})
public class UpdateSt extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        String name, ph, mail;
        name = req.getParameter("Uname");
        ph = req.getParameter("Uph");
        DataBase db = new DataBase("marriage");
        db.tbName = "matrimony";
        try {
            String r = db.select(ph);
             if ((ph.isEmpty()) || (name.isEmpty())){
                RequestDispatcher rdis = req.getRequestDispatcher("/update.html");
                rdis.include(req, res);
                out.println("<script>alert('Input is empty. Please Enter valid Details')</script>");
            }
             else if (ph.equals(r)) {
                out.println("<!DOCTYPE html>\n"
                        + "\n"
                        + "<html>\n"
                        + "\n"
                        + "<head>\n"
                        + "    <title>Tamil Matrimony</title>\n"
                        + "    <meta charset=\"UTF-8\">\n"
                        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                        + "    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n"
                        + "    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n"
                        + "    <link\n"
                        + "        href=\"https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,100;0,300;0,400;0,700;0,900;1,100;1,300;1,400;1,700;1,900&display=swap\"\n"
                        + "        rel=\"stylesheet\">\n"
                        + "    <link rel=\"icon\" href=\"./image/logo.png\">\n"
                        + "    <style>\n"
                        + "        * {\n"
                        + "            margin: 0;\n"
                        + "            padding: 0;\n"
                        + "        }\n"
                        + "\n"
                        + "        body {\n"
                        + "            background-image: url(./image/m1.jpg);\n"
                        + "            background-repeat: no-repeat;\n"
                        + "            background-size: cover;\n"
                        + "            background-position: center center;\n"
                        + "        }\n"
                        + "\n"
                        + "        #update {\n"
                        + "            width: 400px;\n"
                        + "            height: 580px;\n"
                        + "            background-color: white;\n"
                        + "            border: white;\n"
                        + "            box-shadow: 2px 2px 30px black;\n"
                        + "            border-radius: 20px;\n"
                        + "            margin-top: 30px;\n"
                        + "            margin-left: 500px;\n"
                        + "        }\n"
                        + "\n"
                        + "        input {\n"
                        + "            width: 340px;\n"
                        + "            height: 35px;\n"
                        + "            border-radius: 7px;\n"
                        + "            border: 1px solid black;\n"
                        + "            padding-left: 5px;\n"
                        + "            align-items: center;\n"
                        + "            margin-left: 20px;\n"
                        + "            margin-top: 5px;\n"
                        + "            font-size: 15px;\n"
                        + "        }\n"
                        + "        h1{\n"
                        + "            padding-top: 30px;\n"
                        + "            margin-left: 150px;\n"
                        + "            font-family: \"Lato\", sans-serif;\n"
                        + "          font-weight: 600;\n"
                        + "          font-style: normal;\n"
                        + "        }\n"
                        + "        #sub{\n"
                        + "            width: 350px;\n"
                        + "            color: white;\n"
                        + "            background-color: #E06506;\n"
                        + "            height: 40px;\n"
                        + "            border: none;\n"
                        + "        }\n"
                        + "        #back{\n"
                        + "            width: 100px;\n"
                        + "            margin-left: 150px;\n"
                        + "            border: none;\n"
                        + "            background-color: none;\n"
                        + "            color: black;\n"
                        + "        }\n"
                        + "    </style>\n"
                        + "</head>\n"
                        + "\n"
                        + "<body>\n"
                        + "    <div id=\"update\">\n"
                        + "        <form action=\"http://localhost:8080/App/Update\" method=\"post\">\n"
                        + "            <h1>Update</h1>\n"
                        + "            <br><br>\n"
                        + "            <input type=\"text\" placeholder=\"Enter Your Old Name\" name=\"Oname\">\n"
                        + "            <br><br>\n"
                        + "            <input type=\"text\" placeholder=\"Enter Your New Name\" name=\"Nname\">\n"
                        + "            <br><br>\n"
                        + "            <input type=\"text\" placeholder=\"Enter Your Old Phone Number\" name=\"Oph\">\n"
                        + "            <br><br>\n"
                        + "            <input type=\"text\" placeholder=\"Enter Your New Phone Number\" name=\"Nph\">\n"
                        + "            <br><br>\n"
                        + "            <input type=\"text\" placeholder=\"Enter Your Old Email Id\" name=\"Omail\">\n"
                        + "            <br><br>\n"
                        + "            <input type=\"text\" placeholder=\"Enter Your New Email Id\" name=\"Nmail\">\n"
                        + "            <br><br>\n"
                        + "            <input type=\"submit\" value=\"Update\" id=\"sub\">\n"
                        + "            <br><br>\n"
                        + "        </form>\n"
                        + "        <a href=\"./index.html\"><input type=\"submit\" value=\"Back\" id=\"back\"></a>\n"
                        + "    </div>\n"
                        + "</body>\n"
                        + "\n"
                        + "</html>");
            } else {
                RequestDispatcher rdis = req.getRequestDispatcher("/index.html");
                rdis.include(req, res);
                out.println("<script>alert('Invalid profile')</script>");
            }
        } catch (Exception ex) {
            out.println("<script>alert('Login Error:'" + ex + "')</script>");
        }
    }
}
