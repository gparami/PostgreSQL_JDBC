import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Formatter;

public class exercise1 {

    public static void  main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection db = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=laboratories", "postgres", "postgres");
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT aname, dateofbirth FROM artist");
            String format = "%-20s%s%n";
            String name = "NAME";
            String dob = "DOB";
            System.out.printf(format, name, dob);
            while (rs.next()){
                System.out.printf(format, rs.getString(1), rs.getString(2));
            }
            rs.close();
            st.close();
        } catch (Exception e){}
    }
}