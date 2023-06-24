import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDetails extends JFrame {

    private JTextField fn;
    private JTextField ln;
    private JTextField adm;
    private JTextField email;
    private JTextField mob;
    private JButton back;
    private JPanel studDetails;
    JFrame f = new JFrame("Student Details");

    StudentDetails(int admno) {
        f.setContentPane(studDetails);
        f.setMinimumSize(new Dimension(350, 425));
        f.setLocationRelativeTo(f);
        f.setVisible(true);
        f.setResizable(false);

        String fName;
        String lName;
        String admn;
        String mail;
        String mobile;
        try {
            String url = Keys.URL;
            String user = Keys.USER;
            String password = Keys.PASSWORD;
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "select * from studentdetails where adm=" + admno;
            Statement sta = connection.createStatement();
            ResultSet rs = sta.executeQuery(query);

            while (rs.next()) {
                fName = rs.getString("Firstname");
                lName = rs.getString("Lastname");
                admn = Integer.toString(rs.getInt("adm"));
                mail = rs.getString("Email");
                mobile = rs.getString("Mobile");
                fn.setText(fName);
                ln.setText(lName);
                adm.setText(admn);
                email.setText(mail);
                mob.setText(mobile);
                fn.setEditable(false);
                ln.setEditable(false);
                adm.setEditable(false);
                email.setEditable(false);
                mob.setEditable(false);
            }
            connection.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        back.addActionListener(e -> {
                f.dispose();
                new Home();
        });
    }
}
