import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddStudent extends JFrame {

    private JTextField first;
    private JTextField last;
    private JTextField adm;
    private JTextField email;
    private JTextField mobile;
    private JPanel addStud;
    private JTextField pass;
    private JTextField cpass;
    private JButton cancel;
    private JButton submit;
    JFrame f = new JFrame("Add Student");

    AddStudent() {
        f.setContentPane(addStud);
        f.setMinimumSize(new Dimension(350, 425));
        f.setLocationRelativeTo(f);
        f.setVisible(true);

        submit.addActionListener(e -> {
            String firstname = first.getText();
            String lastname = last.getText();
            String emailId = email.getText();
            String m = mobile.getText();
            String ad = adm.getText();
            String passw = pass.getText();
            String cpassw = cpass.getText();

            if (firstname.equals("") || lastname.equals("") || emailId.equals("") || adm.getText().equals("") || mobile.getText().equals("") || passw.equals("") || cpassw.equals("")) {
                JOptionPane.showMessageDialog(submit, "All Fields Must Be Filled");
            } else {
                int admno = Integer.parseInt(ad);
                long mob = Long.parseLong(m);
                int len = 0;
                long mobc = mob;
                while (mobc != 0) {
                    len++;
                    mobc /= 10;
                }
                if ((passw.equals(cpassw))) {
                    String msg = "" + firstname;
                    msg += " \n";
                    if (len != 10) {
                        JOptionPane.showMessageDialog(submit, "Enter a valid mobile number");
                    } else {
                        try {
                            String url = Keys.URL;
                            String user = Keys.USER;
                            String password = Keys.PASSWORD;
                            Connection connection = DriverManager.getConnection(url, user, password);

                            String query = "INSERT INTO StudentDetails values('" + firstname + "','" + lastname + "'," + admno + ",'" +
                                    passw + "','" + emailId + "'," + m + ")";
                            Statement sta = connection.createStatement();
                            int x = sta.executeUpdate(query);
                            if (x == 0) {
                                JOptionPane.showMessageDialog(submit, "This Data already exist");
                            } else {
                                JOptionPane.showMessageDialog(submit, "Welcome " + msg + "\nYour account is successfully created");
                            }
                            first.setText(null);
                            last.setText(null);
                            adm.setText(null);
                            email.setText(null);
                            mobile.setText(null);
                            connection.close();
                            f.dispose();
                            new AdminWindow();
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(submit, "Password Mismatch, \nEnter Again");
                }
            }
        });
        cancel.addActionListener(e -> {
            f.dispose();
            new AdminWindow();
        });
    }
}