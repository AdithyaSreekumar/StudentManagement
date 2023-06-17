import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        String fName;
        String lName;
        String admn;
        String mail;
        String mobile;
        try {
            Keys k = new Keys();
            String url = k.URL;
            String user = k.USER;
            String password = k.PASSWORD;
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
            }
            connection.close();

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Home();
            }
        });
    }
}
