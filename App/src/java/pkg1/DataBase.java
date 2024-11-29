package pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;

public class DataBase {

    public String tbName;
    public String qry;
    public Connection con;
    public PreparedStatement pr;
    public Statement st;
    public ResultSet rs;
    public String result = null;
    public String update = null;

    public DataBase(String dbName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, "maha", "admin");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void insert(String name, String email, String ph) {
        try {
            qry = "Insert Into " + tbName + " values ('" + name + "','" + email + "','" + ph + "')";
            pr = con.prepareStatement(qry);
            pr.execute();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public String select(String ph) {
        try {
            qry = "Select ph from " + tbName + " WHERE ph='" + ph + "'";
            st = con.createStatement();
            rs = st.executeQuery(qry);
            if (rs.next()) {
                result = rs.getString("ph");
            }

        } catch (Exception ex) {
            System.out.println(ex);

        }
        return result;

    }

    public void delete(String ph) {
        try {
            qry = "Delete from " + tbName + " Where ph=" + ph;
            pr = con.prepareStatement(qry);
            pr.execute();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void updateName(String oldName, String newName) {
        try {
            qry = "Update " + tbName + " SET name='" + newName + "' Where name='" + oldName + "'";
            pr = con.prepareStatement(qry);
            pr.execute();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void updateEmail(String oldMail, String newMail) {
        try {
            qry = "Update " + tbName + " SET email='" + newMail + "' Where email='" + oldMail + "'";
            pr = con.prepareStatement(qry);
            pr.execute();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void updatePh(String oldPh, String newPh) {
        try {
            qry = "Update " + tbName + " SET ph='" + newPh + "' Where ph='" + oldPh + "'";
            pr = con.prepareStatement(qry);
            pr.execute();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
