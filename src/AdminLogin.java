import javax.swing.*;
import java.awt.*;

public class AdminLogin extends JFrame{
    private JTextField username;
    private JTextField password;
    private JButton cancel;
    private JButton login;
    private JPanel admin;
    JFrame f=new JFrame("Admin Login");
    AdminLogin(){
        f.setContentPane(admin);
        f.setMinimumSize(new Dimension(350, 425));
        f.setLocationRelativeTo(f);
        f.setVisible(true);
        f.setResizable(false);

        cancel.addActionListener(e -> {
            f.dispose();
            new Home();
        });


        login.addActionListener(e -> {
            String user = username.getText();
            String pass = password.getText();
            if (user.equals("") || pass.equals("")) {
                JOptionPane.showMessageDialog(login, "All Fields Must Be Filled");
            } else {
                if (user.equals("admin") && pass.equals("password")) {
                    JOptionPane.showMessageDialog(login, "Login Successful,\n Welcome.");
                    f.dispose();
                    new AdminWindow();
                } else {
                    JOptionPane.showMessageDialog(login, "Invalid login credentials,\nTry Again.");
                }
            }
        });
    }
}
