import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentLogin extends JFrame{
    private JTextField ut;
    private JTextField pt;
    private JButton cancel;
    private JButton login;
    private JPanel stdLogin;
    JFrame f=new JFrame("Student Login");
    StudentLogin(){
        f.setContentPane(stdLogin);
        f.setMinimumSize(new Dimension(350, 425));
        f.setLocationRelativeTo(f);
        f.setVisible(true);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String admno = ut.getText();
                String pass = pt.getText();
                if (admno.equals("") || pass.equals("")) {
                    JOptionPane.showMessageDialog(login, "All Fields Must Be Filled");
                }
                else {
                    try {
                        Keys k = new Keys();
                        String url = k.URL;
                        String user = k.USER;
                        String password = k.PASSWORD;
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement sta = con.createStatement();
                        String query1 = "select count(*) from studentdetails where adm=" + admno;
                        ResultSet rs1 = sta.executeQuery(query1);
                        while (rs1.next()) {
                            if (rs1.getInt(1) == 1) {
                                String query = "select password from studentdetails where adm=" + admno;
                                ResultSet rs = sta.executeQuery(query);


                                while (rs.next()) {
                                    if (pass.equals(rs.getString("password"))) {
                                        JOptionPane.showMessageDialog(login, "Login Successfull,\n Welcome.");
                                        f.dispose();
                                        int x = Integer.parseInt(admno);
                                        new StudentDetails(x);
                                    } else {
                                        JOptionPane.showMessageDialog(login, "Invalid login credentials,\nTry Again.");
                                    }
                                }
                                ut.setText(null);
                                pt.setText(null);
                                con.close();
                            } else {
                                JOptionPane.showMessageDialog(login, "Invalid Username,\nTry Again.");
                            }
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(login, "Username must only contain integer");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });


        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Home();
            }
        });

    }
}
