import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame{
    private JLabel head;
    private JButton admin;
    private JButton stud;
    private JPanel home;
    JFrame f=new JFrame("College");
    Home(){

        f.setContentPane(home);
        f.setMinimumSize(new Dimension(350, 425));
        f.setLocationRelativeTo(f);
        f.setVisible(true);

        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new AdminLogin();
            }
        });

        stud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new StudentLogin();
            }
        });
    }
}
