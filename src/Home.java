import javax.swing.*;
import java.awt.*;

public class Home extends JFrame{
    private JButton admin;
    private JButton stud;
    private JPanel home;
    JFrame f=new JFrame("College");
    Home(){

        f.setContentPane(home);
        f.setMinimumSize(new Dimension(350, 425));
        f.setLocationRelativeTo(f);
        f.setVisible(true);

        admin.addActionListener(e -> {
            f.dispose();
            new AdminLogin();
        });

        stud.addActionListener(e -> {
            f.dispose();
            new StudentLogin();
        });
    }
}
