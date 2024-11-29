package pkg1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProfileSt", urlPatterns = {"/profile"})
public class ProfileSt extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setHeader("Content-Type", "text/html");
        PrintWriter out = res.getWriter();
        String name, email, ph;
        name = req.getParameter("uname");
        email = req.getParameter("umail");
        ph = req.getParameter("uph");
        out.println("<!DOCTYPE html>\n"
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
                //                                + "               background-color: black;\n"
                + "        }\n"
                + "\n"
                + "        #profile {\n"
                + "            width: 400px;\n"
                + "            height: 400px;\n"
                + "            background-color: none;\n"
                + "            border: white;\n"
                + "            box-shadow: 2px 2px 30px black;\n"
                + "            border-radius: 20px;\n"
                + "            margin-top: 50px;\n"
                + "            margin-left: 100px;\n"
                + "        }\n"
                + "        h3{\n"
                + "            \n"
                + "              color: black;\n"
                + "            font-family: \"Lato\", sans-serif;\n"
                + "            font-weight: 700;\n"
                + "            font-style: normal;\n"
                + "            padding-top: 45px;\n"
                + "            margin-left: 20px;\n"
                + "        }\n"
                + "        h1{\n"
                + "             color: black;\n"
                + "            margin-left: 150px;\n"
                + "            font-family: \"Lato\", sans-serif;\n"
                + "            font-weight: 700;\n"
                + "            font-style: normal;\n"
                + "            padding-top: 20px;\n"
                + "        }\n"
                + "        #sub{\n"
                + "            width: 250px;\n"
                + "            color: white;\n"
                + "            background-color: #E06506;\n"
                + "            height: 40px;\n"
                + "            border: none;\n"
                + "            margin-left: 70px;\n"
                + "            margin-top: 30px;\n"
                + "            border-radius: 20px;\n"
                + "            font-family: \"Lato\", sans-serif;\n"
                + "            font-weight: 700;\n"
                + "            font-style: normal;\n"
                + "        }\n"
                + "          a{\n"
                + "            text-decoration: none;\n"
                + "            color: black;\n"
                + "            margin-left: 170px;\n"
                + "            font-family: \"Lato\", sans-serif;\n"
                + "            font-weight: 200;\n"
                + "            font-style: normal;\n"
                + "        }\n"
                + "        img {\n"
                + "             width: 140px;\n"
                + "             border-radius: 140px;\n"
                + "             margin-top: 20px\n"
                + "            }"
                + "    </style>\n"
                + "</head>\n"
                + "\n"
                + "<body>\n"
                + "            <img src=\"./image/logo.png\" alt=\"\">\n"
                + "        <div id=\"profile\">\n"
                + "            <h1>Profile</h1>\n"
                + "            <h3>Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: " + name + "</h3>\n"
                + "            <h3>Email Id&nbsp;&nbsp;&nbsp;&nbsp; : " + email + "</h3>\n"
                + "            <h3>Phone No   : " + ph + "</h3>\n"
                + "            <input type=\"submit\" value=\"Upload Image\" id=\"sub\">\n"
                + "            <br><br>\n"
                + "            <a href=\"./index.html\">Back</a>\n"
                + "        </div>\n"
                + "</body>\n"
                + "\n"
                + "</html>");
    }
}

