import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Home();
            }
        });


        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user=username.getText();
                String pass=password.getText();
                if(user.equals("admin") && pass.equals("password")){
                    JOptionPane.showMessageDialog(login, "Login Successfull,\n Welcome.");
                    f.dispose();
                    new AdminWindow();
                }
                else {
                    JOptionPane.showMessageDialog(login, "Invalid login credentials,\nTry Again.");
                }
            }
        });
    }
}
